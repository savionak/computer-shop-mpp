package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.dto.PageDto;
import by.bsuir.mpp.computershop.dto.brief.*;
import by.bsuir.mpp.computershop.dto.full.AssemblyComponentFullDto;
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
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DtoMapperConfiguration {

    private MapperFactory mapperFactory;

    @Autowired
    DtoMapperConfiguration(PasswordEncoder passwordEncoder) {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Assembly.class, AssemblyBriefDto.class)
                .field("order.id", "orderId")
                .byDefault()
                .register();

        mapperFactory.classMap(AssemblyComponent.class, AssemblyComponentBriefDto.class)
                .field("component.id", "storeId")
                .field("component.model.id", "modelId")
                .field("component.model.name", "modelName")
                .field("component.model.type.id", "typeId")
                .field("component.model.type.name", "typeName")
                .field("component.price", "price")
                .byDefault()
                .register();
        mapperFactory.classMap(AssemblyComponent.class, AssemblyComponentFullDto.class)
                .field("assembly.id", "assemblyId")
                .byDefault()
                .register();

        mapperFactory.classMap(ComponentModel.class, ComponentModelBriefDto.class)
                .field("type.id", "typeId")
                .field("type.name", "typeName")
                .byDefault()
                .register();

        mapperFactory.classMap(ComponentStore.class, ComponentStoreBriefDto.class)
                .field("model.id", "modelId")
                .field("model.name", "modelName")
                .field("model.type.id", "typeId")
                .field("model.type.name", "typeName")
                .byDefault()
                .register();

        mapperFactory.classMap(Import.class, ImportFullDto.class)
                .field("stored.count", "storedCount")
                .byDefault()
                .register();
        mapperFactory.classMap(Import.class, ImportBriefDto.class)
                .field("model.id", "modelId")
                .field("model.name", "modelName")
                .field("model.type.id", "typeId")
                .field("model.type.name", "typeName")
                .field("provider.name", "providerName")
                .byDefault()
                .register();

        mapperFactory.classMap(UserAuth.class, UserBriefDto.class)
                .field("userInfo.firstName", "firstName")
                .field("userInfo.lastName", "lastName")
                .byDefault()
                .register();
        mapperFactory.getConverterFactory().registerConverter(new UserAuthConverter(passwordEncoder));

        mapperFactory.getConverterFactory().registerConverter(new PageInfoConverter());
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
            result.setUserInfo(userInfo, true);

            String pass = userAuthFullDto.getPass();
            if (pass != null) {
                result.setPassHash(passwordEncoder.encode(pass));
            }
            return result;
        }
    }

    private class PageInfoConverter extends CustomConverter<Page, PageDto.PageInfo> {

        @Override
        public PageDto.PageInfo convert(Page page, Type<? extends PageDto.PageInfo> type) {
            PageDto.PageInfo result = new PageDto.PageInfo();

            result.setTotalPages(page.getTotalPages());
            result.setNumber(page.getNumber());

            result.setFirst(page.isFirst());
            result.setLast(page.isLast());
            result.setHasNext(page.hasNext());
            result.setHasPrevious(page.hasPrevious());

            result.setSize(page.getSize());
            result.setTotalElements(page.getTotalElements());
            result.setNumberOfElements(page.getNumberOfElements());

            return result;
        }
    }
}
