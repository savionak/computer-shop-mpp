package by.bsuir.mpp.computershop.config.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    private final Logger logger = Logger.getLogger(CustomTokenEnhancer.class);

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        UserDetails userDetails = (UserDetails) oAuth2Authentication.getPrincipal();

        logger.info("Enhancing token for" + userDetails.getUsername());

        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("authorities", userDetails.getAuthorities());

        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
