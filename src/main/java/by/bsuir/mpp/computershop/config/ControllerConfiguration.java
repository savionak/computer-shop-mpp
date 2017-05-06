package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.controller.*;
import by.bsuir.mpp.computershop.controller.impl.*;
import by.bsuir.mpp.computershop.service.*;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
public class ControllerConfiguration {

    @Bean
    public AssemblyController assemblyController(AssemblyService assemblyService, MapperFacade mapperFacade) {
        return new AssemblyControllerImpl(assemblyService, mapperFacade);
    }

    @Bean
    public ComponentModelController componentModelController(ComponentModelService componentModelService, MapperFacade mapperFacade) {
        return new ComponentModelControllerImpl(componentModelService, mapperFacade);
    }

    @Bean
    public ComponentStoreController componentStoreController(ComponentStoreService storeService, MapperFacade mapperFacade) {
        return new ComponentStoreControllerImpl(storeService, mapperFacade);
    }

    @Bean
    public ComponentTypeController componentTypeController(ComponentTypeService componentTypeService, MapperFacade mapperFacade) {
        return new ComponentTypeControllerImpl(componentTypeService, mapperFacade);
    }

    @Bean
    public CustomerController customerController(CustomerService customerService, MapperFacade mapperFacade) {
        return new CustomerControllerImpl(customerService, mapperFacade);
    }

    @Bean
    public ExportController exportController(ExportService exportService, MapperFacade mapperFacade) {
        return new ExportControllerImpl(exportService, mapperFacade);
    }

    @Bean
    public ImportController importController(ImportService importService, MapperFacade mapperFacade) {
        return new ImportControllerImpl(importService, mapperFacade);
    }

    @Bean
    public LogoutController logoutController(DefaultTokenServices tokenServices) {
        return new LogoutControllerImpl(tokenServices);
    }

    @Bean
    public OrderController orderController(OrderService orderService, MapperFacade mapperFacade) {
        return new OrderControllerImpl(orderService, mapperFacade);
    }

    @Bean
    public ProviderController providerController(ProviderService providerService, MapperFacade mapperFacade) {
        return new ProviderControllerImpl(providerService, mapperFacade);
    }

    @Bean
    public UserAuthController userAuthController(UserAuthService userAuthService, MapperFacade mapperFacade) {
        return new UserAuthControllerImpl(userAuthService, mapperFacade);
    }
}
