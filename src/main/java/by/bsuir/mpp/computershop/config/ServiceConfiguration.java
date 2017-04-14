package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.repository.ImportRepository;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.ImportService;
import by.bsuir.mpp.computershop.service.ProviderService;
import by.bsuir.mpp.computershop.service.impl.ComponentModelServiceImpl;
import by.bsuir.mpp.computershop.service.impl.ComponentTypeServiceImpl;
import by.bsuir.mpp.computershop.service.impl.ImportServiceImpl;
import by.bsuir.mpp.computershop.service.impl.ProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    ComponentTypeService componentTypeService(ComponentTypeRepository componentTypeRepository) {
        return new ComponentTypeServiceImpl(componentTypeRepository);
    }

    @Bean
    ComponentModelService componentModelService(ComponentModelRepository componentModelRepository,
                                                ComponentTypeRepository typeRepository) {
        return new ComponentModelServiceImpl(componentModelRepository, typeRepository);
    }

    @Bean
    ProviderService providerService(ProviderRepository providerRepository) {
        return new ProviderServiceImpl(providerRepository);
    }

    @Bean
    ImportService importService(ImportRepository importRepository,
                                ProviderRepository providerRepository,
                                ComponentModelRepository modelRepository) {
        return new ImportServiceImpl(importRepository, providerRepository, modelRepository);
    }

}
