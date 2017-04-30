package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ComponentStoreBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ImportBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentModelFullDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/component/model")
public interface ComponentModelController
        extends CrudController<ComponentModelBriefDto, ComponentModelFullDto, Long> {

    @RequestMapping(path = "{id}/imports")
    Iterable<ImportBriefDto> getImports(@PathVariable Long id) throws ControllerException;

    @RequestMapping(path = "{id}/stored")
    Iterable<ComponentStoreBriefDto> getStoredItems(@PathVariable Long id) throws ControllerException;
}
