package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.Provider;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/provider")
public interface ProviderController extends CrudController<Provider, Long> {

    @RequestMapping(path = "{id}/imports", method = RequestMethod.GET)
    Iterable<Import> getImports(@PathVariable Long id) throws ControllerException;
}
