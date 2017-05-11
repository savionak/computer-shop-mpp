package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.AssemblyController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.dto.PageDto;
import by.bsuir.mpp.computershop.dto.brief.AssemblyBriefDto;
import by.bsuir.mpp.computershop.dto.brief.AssemblyComponentBriefDto;
import by.bsuir.mpp.computershop.dto.full.AssemblyComponentFullDto;
import by.bsuir.mpp.computershop.dto.full.AssemblyFullDto;
import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.service.AssemblyComponentService;
import by.bsuir.mpp.computershop.service.AssemblyService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class AssemblyControllerImpl
        extends AbstractCrudController<AssemblyBriefDto, AssemblyFullDto, Assembly, Long>
        implements AssemblyController {

    private static final Logger logger = Logger.getLogger(AssemblyControllerImpl.class);
    private final AssemblyService assemblyService;
    private final AssemblyComponentService componentService;
    private final MapperFacade mapper;

    @Autowired
    public AssemblyControllerImpl(AssemblyService assemblyService,
                                  AssemblyComponentService componentService,
                                  MapperFacade mapper) {
        super(assemblyService, mapper, AssemblyBriefDto.class, AssemblyFullDto.class, Assembly.class, logger);
        this.assemblyService = assemblyService;
        this.componentService = componentService;
        this.mapper = mapper;
    }

    @Override
    public PageDto getListByOrderId(@PathVariable("id") Long orderId, Pageable pageable) throws ControllerException {
        logger.info(String.format("GET LIST by ORDER [%s]", orderId));
        Page<Assembly> components =
                wrapServiceCall(() -> assemblyService.getListByOrderId(orderId, pageable), logger);
        return asPageDto(components, AssemblyBriefDto.class);
    }

    @Override
    public PageDto getComponentsList(@PathVariable("id") Long assemblyId, Pageable pageable) throws ControllerException {
        logger.info(String.format("GET COMPONENTS LIST of ASSEMBLY [%s]", assemblyId));
        Page<AssemblyComponent> components =
                wrapServiceCall(() -> componentService.getByAssemblyId(assemblyId, pageable), logger);
        return asPageDto(components, AssemblyComponentBriefDto.class);
    }

    @Override
    public AssemblyComponentFullDto getComponent(@PathVariable("id") Long assemblyId, @PathVariable("component_id") Long componentId)
            throws ControllerException {
        logger.info(String.format("GET COMPONENT [%s] of ASSEMBLY [%s]", componentId, assemblyId));
        AssemblyComponent component = getCheckComponent(assemblyId, componentId);
        return mapper.map(component, AssemblyComponentFullDto.class);
    }

    @Override
    public AssemblyComponentFullDto addComponent(@PathVariable("id") Long assemblyId,
                                                 @RequestBody AssemblyComponentFullDto componentDto)
            throws ControllerException {
        logger.info(String.format("ADD COMPONENT to ASSEMBLY [%s]", assemblyId));
        componentDto.setAssemblyId(assemblyId);
        AssemblyComponent component = mapper.map(componentDto, AssemblyComponent.class);
        AssemblyComponent result = wrapServiceCall(() -> componentService.add(component), logger);
        return mapper.map(result, AssemblyComponentFullDto.class);
    }

    @Override
    public AssemblyComponentFullDto updateComponent(@PathVariable("id") Long assemblyId,
                                                    @PathVariable("component_id") Long componentId,
                                                    @RequestBody AssemblyComponentFullDto componentDto)
            throws ControllerException {
        logger.info(String.format("UPDATE COMPONENT [%s] of ASSEMBLY [%s]", componentId, assemblyId));
        getCheckComponent(assemblyId, componentId);
        componentDto.setAssemblyId(assemblyId);
        AssemblyComponent component = mapper.map(componentDto, AssemblyComponent.class);
        AssemblyComponent result = wrapServiceCall(() -> componentService.update(componentId, component), logger);
        return mapper.map(result, AssemblyComponentFullDto.class);
    }

    @Override
    public void deleteComponent(@PathVariable("id") Long assemblyId, @PathVariable("component_id") Long componentId)
            throws ControllerException {
        logger.info(String.format("DELETE COMPONENT [%s] of ASSEMBLY [%s]", componentId, assemblyId));
        getCheckComponent(assemblyId, componentId);
        wrapServiceCall(() -> componentService.delete(componentId), logger);
    }

    private AssemblyComponent getCheckComponent(@PathVariable("id") Long assemblyId,
                                                @PathVariable("component_id") Long componentId)
            throws ControllerException {
        AssemblyComponent component = wrapServiceCall(() -> componentService.getOne(componentId), logger);
        if (!Objects.equals(component.getAssembly().getId(), assemblyId)) {
            throw new ResourceNotFoundException(
                    String.format("Component with id = [%s] of Assembly [%s] not found.", component, assemblyId));
        }
        return component;
    }
}
