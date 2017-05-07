package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.UserAuthController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.UserBriefDto;
import by.bsuir.mpp.computershop.dto.full.UpdatePassDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.service.UserAuthService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class UserAuthControllerImpl
        extends AbstractCrudController<UserBriefDto, UserAuthFullDto, UserAuth, Long>
        implements UserAuthController {

    private static final Logger logger = Logger.getLogger(UserAuthControllerImpl.class);
    private final PasswordEncoder passwordEncoder;
    private final UserAuthService userService;

    @Autowired
    public UserAuthControllerImpl(UserAuthService userAuthService, MapperFacade mapper, PasswordEncoder passwordEncoder) {
        super(userAuthService, mapper, UserBriefDto.class, UserAuthFullDto.class, UserAuth.class, logger);
        this.userService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void updatePassword(@RequestBody UpdatePassDto passDto) throws ControllerException {
        logger.info(String.format("UPDATE PASS of user with id = [%s]", passDto.getUserId().toString()));
        String passHash = passwordEncoder.encode(passDto.getNewHash());
        passDto.setNewHash(passHash);
        wrapServiceCall(() -> userService.updatePasswordHash(passDto), logger);
    }
}
