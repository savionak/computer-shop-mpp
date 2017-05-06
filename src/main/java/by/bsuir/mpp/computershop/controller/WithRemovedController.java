package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.PageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface WithRemovedController {

    @RequestMapping(path = "removed", method = RequestMethod.GET)
    PageDto getRemoved(Pageable pageable) throws ControllerException;
}
