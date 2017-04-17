package by.bsuir.mpp.computershop.config.security;

import by.bsuir.mpp.computershop.repository.EmployeeAuthRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

@Configuration
@EnableWebSecurity
@Import({
        AuthorizationServerConfiguration.class,
        ResourceServerConfiguration.class,
        MethodSecurityConfiguration.class
})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final int BCRYPT_STRENGTH = 12;
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();   // to Autowire in AuthorizationServerConfiguration
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCRYPT_STRENGTH);
    }

    @Bean
    public UserDetailsService userDetailsService(EmployeeAuthRepository authRepository) {
        userDetailsService = new JdbcUserDetailsService(authRepository);
        return userDetailsService;
    }
}
