package by.bsuir.mpp.computershop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    public static ModelMapper mapper;

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }
}
