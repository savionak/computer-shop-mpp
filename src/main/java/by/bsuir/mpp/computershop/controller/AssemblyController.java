package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.PageDto;
import by.bsuir.mpp.computershop.dto.brief.AssemblyBriefDto;
import by.bsuir.mpp.computershop.dto.full.AssemblyComponentFullDto;
import by.bsuir.mpp.computershop.dto.full.AssemblyFullDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/assembly")
public interface AssemblyController
        extends CrudController<AssemblyBriefDto, AssemblyFullDto, Long> {

    @RequestMapping(value = "{id}/components", method = RequestMethod.GET)
    PageDto getComponentsList(@PathVariable("id") Long assemblyId, Pageable pageable) throws ControllerException;

    @RequestMapping(value = "{id}/components/{component_id}")
    AssemblyComponentFullDto getComponent(@PathVariable("id") Long assemblyId, @PathVariable("component_id") Long componentId)
            throws ControllerException;

    @RequestMapping(value = "{id}/components/add")
    AssemblyComponentFullDto addComponent(@PathVariable("id") Long assemblyId, @RequestBody AssemblyComponentFullDto component)
            throws ControllerException;

    @RequestMapping(value = "{id}/components/update/{component_id}")
    AssemblyComponentFullDto updateComponent(@PathVariable("id") Long assemblyId, @PathVariable("component_id") Long componentId,
                                             @RequestBody AssemblyComponentFullDto componentDto)
            throws ControllerException;

    @RequestMapping(value = "{id}/components/delete/{component_id}")
    void deleteComponent(@PathVariable("id") Long assemblyId, @PathVariable("component_id") Long componentId)
            throws ControllerException;
}
