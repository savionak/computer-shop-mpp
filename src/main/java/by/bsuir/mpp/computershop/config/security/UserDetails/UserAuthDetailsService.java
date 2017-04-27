package by.bsuir.mpp.computershop.config.security.UserDetails;

import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.slf4j.LoggerFactory.getLogger;

public class UserAuthDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private static final Logger logger = getLogger(UserAuthDetailsService.class);
    private static final String ENCODING = "UTF-8";
    private final UserAuthRepository authRepository;

    public UserAuthDetailsService(UserAuthRepository authRepository) {
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
        UserAuth user = authRepository.findByEmail(username);
        if (user == null) {
            logger.info("User [" + username + "] not found");
            throw new UsernameNotFoundException("User [" + username + "] not found");
        }
        return new UserAuthDetails(user);
    }

}
