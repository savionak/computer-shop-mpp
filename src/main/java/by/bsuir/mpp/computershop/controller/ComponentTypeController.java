package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ComponentTypeBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentTypeFullDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/component/type")
public interface ComponentTypeController
        extends CrudController<ComponentTypeBriefDto, ComponentTypeFullDto, Long> {

    @RequestMapping(path = "{id}/models", method = RequestMethod.GET)
    Iterable<ComponentModelBriefDto> getModels(@PathVariable Long id) throws ControllerException;
}
