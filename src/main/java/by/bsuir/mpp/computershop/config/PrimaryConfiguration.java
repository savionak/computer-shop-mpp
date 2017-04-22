package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.config.security.SecurityConfiguration;
import by.bsuir.mpp.computershop.controller.exception.handler.GlobalRestExceptionHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({
        PersistenceConfiguration.class,
        EntityManagerFactoriesConfiguration.class,
        TransactionManagerConfiguration.class,
        ServiceConfiguration.class,
        ControllerConfiguration.class,
        SecurityConfiguration.class
})
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration.class
})
@EnableTransactionManagement
public class PrimaryConfiguration extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PrimaryConfiguration.class);
    }

    @Bean
    GlobalRestExceptionHandler globalRestExceptionHandler() {
        return new GlobalRestExceptionHandler();
    }
}
