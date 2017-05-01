package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.brief.pages.PageDto;
import by.bsuir.mpp.computershop.dto.full.BaseFullDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.Serializable;

public interface CrudController<B extends BaseBriefDto<ID>, F extends BaseFullDto<ID>, ID extends Serializable> {

    @RequestMapping(path = "add", method = RequestMethod.POST)
    F add(@Valid @RequestBody F dto) throws ControllerException;

    @RequestMapping(path = "update", method = RequestMethod.PUT)
    F update(@Valid @RequestBody F entity) throws ControllerException;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    F getById(@PathVariable ID id) throws ControllerException;

    @RequestMapping(method = RequestMethod.GET)
    PageDto getAll(Pageable pageable) throws ControllerException;

    @RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable ID id) throws ControllerException;
}
