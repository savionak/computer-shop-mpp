package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.UserBriefDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/user")
public interface UserAuthController
        extends CrudController<UserBriefDto, UserAuthFullDto, Long> {
}
