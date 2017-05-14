package by.bsuir.mpp.computershop.config.security;

import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public ResourceServerConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .tokenStore(tokenStore());
        resources.stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String DIRECTOR = UserAuth.Role.DIRECTOR.name();
        String MANAGER = UserAuth.Role.MANAGER.name();
        String ADMIN = UserAuth.Role.ADMIN.name();

        http.
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").anonymous()
                .antMatchers(HttpMethod.POST, "/oauth/revoke_token").authenticated()

                .antMatchers(HttpMethod.GET, "/api/**").authenticated()

                .antMatchers("/api/provider/**").hasAnyAuthority(DIRECTOR, ADMIN)

                .antMatchers("/api/order/**",
                        "/api/customer/**",
                        "/api/component/store/**",
                        "/api/assembly",
                        "/api/imports",
                        "/api/component/model").hasAnyAuthority(MANAGER, ADMIN)

                .antMatchers("/api/user/**", "/api/component/type/**").hasAuthority(ADMIN)
        ;
    }
}
