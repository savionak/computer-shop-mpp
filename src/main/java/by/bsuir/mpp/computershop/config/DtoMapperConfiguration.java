package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.dto.*;
import by.bsuir.mpp.computershop.entity.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoMapperConfiguration {

    private static MapperFactory mapperFactory;

    @Bean
    public MapperFacade modelMapper() {
        return mapperFactory.getMapperFacade();
    }

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(ComponentModel.class, ComponentModelDto.class)
                .field("type.id", "typeId")
                .byDefault()
                .register();
        mapperFactory.classMap(ComponentStore.class, ComponentStoreDto.class)
                .field("model.id", "modelId")
                .byDefault()
                .register();
        mapperFactory.classMap(Import.class, ImportDto.class)
                .field("stored.count", "storedCount")
                .byDefault()
                .register();
        mapperFactory.classMap(Export.class, ExportDto.class)
                .field("order.id", "orderId")
                .byDefault()
                .register();
        mapperFactory.classMap(UserInfo.class, UserInfoDto.class)
                .field("userAuth.id", "authId")
                .byDefault()
                .register();
    }
}
