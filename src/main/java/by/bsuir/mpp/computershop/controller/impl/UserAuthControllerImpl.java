package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.UserAuthController;
import by.bsuir.mpp.computershop.dto.brief.UserBriefDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.service.UserAuthService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthControllerImpl
        extends AbstractCrudController<UserBriefDto, UserAuthFullDto, UserAuth, Long>
        implements UserAuthController {

    private static final Logger logger = Logger.getLogger(UserAuthControllerImpl.class);

    @Autowired
    public UserAuthControllerImpl(UserAuthService userAuthService, MapperFacade mapper) {
        super(userAuthService, mapper, UserBriefDto.class, UserAuthFullDto.class, UserAuth.class, logger);
    }

}
