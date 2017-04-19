package by.bsuir.mpp.computershop.config.security;

import by.bsuir.mpp.computershop.entity.EmployeeAuth;
import by.bsuir.mpp.computershop.repository.EmployeeAuthRepository;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.slf4j.LoggerFactory.getLogger;

public class JdbcUserDetailsService implements UserDetailsService {

    private static final Logger logger = getLogger(JdbcUserDetailsService.class);
    private static final String ENCODING = "UTF-8";
    private final EmployeeAuthRepository authRepository;

    JdbcUserDetailsService(EmployeeAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("User with username = [" + username + "] is trying to log in");
        try {
            username = URLDecoder.decode(username, ENCODING);
        } catch (UnsupportedEncodingException e) {
            logger.info("Unsupported encoding for username [" + username + "]");
            throw new UsernameNotFoundException("Unsupported encoding");
        }
        EmployeeAuth user = authRepository.findByEmail(username);
        if (user == null) {
            logger.info("User [" + username + "] not found");
            throw new UsernameNotFoundException("User [" + username + "] not found");
        }
        return new UserAuthDetails(user);
    }

}
