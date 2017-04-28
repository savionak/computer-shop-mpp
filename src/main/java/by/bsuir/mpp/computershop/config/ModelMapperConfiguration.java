package by.bsuir.mpp.computershop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    private static ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        modelMapper = new ModelMapper();
        return modelMapper;
    }
}
