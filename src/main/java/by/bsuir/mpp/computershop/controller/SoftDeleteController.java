package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.PageDto;
import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.full.BaseFullDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

public interface SoftDeleteController<B extends BaseBriefDto<ID>, F extends BaseFullDto<ID>, ID extends Serializable>
        extends CrudController<B, F, ID>{

    @RequestMapping(path = "removed", method = RequestMethod.GET)
    PageDto getRemoved(Pageable pageable) throws ControllerException;

    @RequestMapping(path = "restore/{id}", method = RequestMethod.POST)
    void restore(@PathVariable ID id) throws ControllerException;
}
