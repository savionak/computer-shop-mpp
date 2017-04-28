package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.dto.ComponentModelDto;
import by.bsuir.mpp.computershop.dto.ComponentStoreDto;
import by.bsuir.mpp.computershop.dto.ExportDto;
import by.bsuir.mpp.computershop.dto.UserInfoDto;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.Export;
import by.bsuir.mpp.computershop.entity.UserInfo;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

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
