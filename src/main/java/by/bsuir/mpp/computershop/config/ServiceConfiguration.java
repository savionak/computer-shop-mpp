package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.repository.*;
import by.bsuir.mpp.computershop.service.*;
import by.bsuir.mpp.computershop.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    ComponentTypeService componentTypeService(ComponentTypeRepository componentTypeRepository) {
        return new ComponentTypeServiceImpl(componentTypeRepository);
    }

    @Bean
    ComponentModelService componentModelService(ComponentModelRepository componentModelRepository) {
        return new ComponentModelServiceImpl(componentModelRepository);
    }

    @Bean
    ProviderService providerService(ProviderRepository providerRepository) {
        return new ProviderServiceImpl(providerRepository);
    }

    @Bean
    ImportService importService(ImportRepository importRepository) {
        return new ImportServiceImpl(importRepository);
    }

    @Bean
    ComponentStoreService componentStoreService(ComponentStoreRepository storeRepository) {
        return new ComponentStoreServiceImpl(storeRepository);
    }

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }
}
