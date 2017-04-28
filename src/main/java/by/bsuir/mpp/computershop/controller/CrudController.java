package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.entity.dto.BaseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.Serializable;

public interface CrudController<E extends BaseEntity<ID>, ID extends Serializable> {

    @RequestMapping(path = "add", method = RequestMethod.POST)
    E add(@Valid @RequestBody E entity) throws ControllerException;

    @RequestMapping(path = "update", method = RequestMethod.PUT)
    E update(@Valid @RequestBody E entity) throws ControllerException;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    E getById(@PathVariable ID id) throws ControllerException;

    @RequestMapping(method = RequestMethod.GET)
    Iterable<BaseDto> getAll() throws ControllerException;

    @RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable ID id) throws ControllerException;
}
