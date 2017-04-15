package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/component/type")
public interface ComponentTypeController extends CrudController<ComponentType, Long> {

    @RequestMapping(path = "{id}/models", method = RequestMethod.GET)
    Iterable<ComponentModel> getModels(@PathVariable Long id) throws ControllerException;
}
