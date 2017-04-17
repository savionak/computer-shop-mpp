package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.LogoutController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

public class LogoutControllerImpl implements LogoutController {

    private final Logger logger = Logger.getLogger(LogoutControllerImpl.class);

    private final DefaultTokenServices tokenServices;

    @Autowired
    public LogoutControllerImpl(DefaultTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

    @Override
    public void revokeToken(OAuth2Authentication auth) {
        logger.info(auth);
        OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) auth.getDetails();
        String tokenValue = authDetails.getTokenValue();
        logger.info("Logging out with token: " + tokenValue);
        tokenServices.revokeToken(tokenValue);
    }

}
