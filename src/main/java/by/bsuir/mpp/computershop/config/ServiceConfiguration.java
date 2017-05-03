package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.repository.*;
import by.bsuir.mpp.computershop.service.*;
import by.bsuir.mpp.computershop.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    AssemblyComponentService assemblyComponentService(AssemblyComponentRepository assemblyComponentRepository) {
        return new AssemblyComponentServiceImpl(assemblyComponentRepository);
    }

    @Bean
    AssemblyService assemblyService(AssemblyRepository assemblyRepository) {
        return new AssemblyServiceImpl(assemblyRepository);
    }

    @Bean
    ComponentModelService componentModelService(ComponentModelRepository componentModelRepository) {
        return new ComponentModelServiceImpl(componentModelRepository);
    }

    @Bean
    ComponentStoreService componentStoreService(ComponentStoreRepository storeRepository) {
        return new ComponentStoreServiceImpl(storeRepository);
    }

    @Bean
    ComponentTypeService componentTypeService(ComponentTypeRepository componentTypeRepository) {
        return new ComponentTypeServiceImpl(componentTypeRepository);
    }

    @Bean
    CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }

    @Bean
    ExportService exportService(ExportRepository exportRepository) {
        return new ExportServiceImpl(exportRepository);
    }

    @Bean
    ImportService importService(ImportRepository importRepository) {
        return new ImportServiceImpl(importRepository);
    }

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    ProviderService providerService(ProviderRepository providerRepository) {
        return new ProviderServiceImpl(providerRepository);
    }

    @Bean
    UserAuthService userAuthService(UserAuthRepository userAuthRepository) {
        return new UserAuthServiceImpl(userAuthRepository);
    }
}
