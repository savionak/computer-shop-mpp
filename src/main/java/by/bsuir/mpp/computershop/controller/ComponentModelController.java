package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/componentModel")
public interface ComponentModelController extends CrudController<ComponentModel, Long> {

    @RequestMapping(path = "{id}/imports")
    Iterable<Import> getImports(@PathVariable Long id) throws ControllerException;
}
