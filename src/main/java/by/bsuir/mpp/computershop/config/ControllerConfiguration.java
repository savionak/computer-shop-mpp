package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.controller.ComponentModelController;
import by.bsuir.mpp.computershop.controller.ComponentTypeController;
import by.bsuir.mpp.computershop.controller.impl.ComponentModelControllerImpl;
import by.bsuir.mpp.computershop.controller.impl.ComponentTypeControllerImpl;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
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
}
