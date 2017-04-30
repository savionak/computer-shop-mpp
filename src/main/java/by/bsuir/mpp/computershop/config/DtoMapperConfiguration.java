package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ComponentStoreDto;
import by.bsuir.mpp.computershop.dto.brief.ImportBriefDto;
import by.bsuir.mpp.computershop.dto.brief.UserBriefDto;
import by.bsuir.mpp.computershop.dto.full.ImportFullDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.entity.*;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DtoMapperConfiguration {

    private MapperFactory mapperFactory;

    @Autowired
    DtoMapperConfiguration(PasswordEncoder passwordEncoder) {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(ComponentModel.class, ComponentModelBriefDto.class)
                .field("type.id", "typeId")
                .byDefault()
                .register();

        mapperFactory.classMap(ComponentStore.class, ComponentStoreBriefDto.class)
                .field("model.type.name", "typeName")
                .field("model.name", "modelName")
                .byDefault()
                .register();

        mapperFactory.classMap(Import.class, ImportBriefDto.class)
                .field("model.type.name", "typeName")
                .field("model.name", "modelName")
                .field("provider.name", "providerName")
                .byDefault()
                .register();
        mapperFactory.classMap(Import.class, ImportFullDto.class)
                .field("stored.count", "storedCount")
                .byDefault()
                .register();

        mapperFactory.classMap(UserAuth.class, UserBriefDto.class)
                .field("userInfo.firstName", "firstName")
                .field("userInfo.lastName", "lastName")
                .byDefault()
                .register();
        mapperFactory.getConverterFactory().registerConverter(new UserAuthConverter(passwordEncoder));
    }

    @Bean
    public MapperFacade modelMapper() {
        return mapperFactory.getMapperFacade();
    }

    private class UserAuthConverter extends CustomConverter<UserAuthFullDto, UserAuth> {

        private PasswordEncoder passwordEncoder;

        UserAuthConverter(PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public UserAuth convert(UserAuthFullDto userAuthFullDto, Type<? extends UserAuth> type) {
            UserAuth result = new UserAuth();

            result.setId(userAuthFullDto.getId());
            result.setEmail(userAuthFullDto.getEmail());
            result.setRole(userAuthFullDto.getRole());
            result.setBlocked(userAuthFullDto.isBlocked());
            result.setRemoved(userAuthFullDto.isRemoved());

            UserInfo userInfo = modelMapper().map(userAuthFullDto.getUserInfo(), UserInfo.class);
            userInfo.setUserAuth(result);

            result.setUserInfo(userInfo);

            String pass = userAuthFullDto.getPass();
            if (pass != null) {
                result.setPassHash(passwordEncoder.encode(pass));
            }
            return result;
        }
    }
}
