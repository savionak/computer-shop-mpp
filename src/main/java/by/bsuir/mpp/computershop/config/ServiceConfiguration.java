package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.impl.ComponentTypeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    ComponentTypeService componentTypeService(ComponentTypeRepository componentTypeRepository) {
        return new ComponentTypeServiceImpl(componentTypeRepository);
    }
}
