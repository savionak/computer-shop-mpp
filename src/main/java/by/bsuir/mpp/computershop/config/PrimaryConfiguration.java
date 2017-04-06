package by.bsuir.mpp.computershop.config;

import by.bsuir.mpp.computershop.controller.exception.handler.GlobalRestExceptionHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PersistenceConfiguration.class,
        ServiceConfiguration.class,
        ControllerConfiguration.class
})
@EnableAutoConfiguration
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
