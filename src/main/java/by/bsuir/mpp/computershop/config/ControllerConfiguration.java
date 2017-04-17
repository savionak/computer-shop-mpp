package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.controller.*;
import by.bsuir.mpp.computershop.controller.impl.*;
import by.bsuir.mpp.computershop.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public ComponentTypeController componentTypeController(ComponentTypeService componentTypeService) {
        return new ComponentTypeControllerImpl(componentTypeService);
    }

    @Bean
    public ComponentModelController componentModelController(ComponentModelService componentModelService) {
        return new ComponentModelControllerImpl(componentModelService);
    }

    @Bean
    public ProviderController providerController(ProviderService providerService) {
        return new ProviderControllerImpl(providerService);
    }

    @Bean
    public ImportController importController(ImportService importService) {
        return new ImportControllerImpl(importService);
    }

    @Bean
    public ComponentStoreController componentStoreController(ComponentStoreService storeService) {
        return new ComponentStoreControllerImpl(storeService);
    }
}
