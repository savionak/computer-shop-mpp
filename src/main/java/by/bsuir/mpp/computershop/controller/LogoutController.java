package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface LogoutController {

    @RequestMapping(path = "/oauth/revoke_token", method = RequestMethod.POST)
    void revokeToken(OAuth2Authentication auth) throws ControllerException;

}
