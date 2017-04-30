package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentTypeController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ComponentTypeBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentTypeFullDto;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class ComponentTypeControllerImpl
        extends AbstractCrudController<ComponentTypeBriefDto, ComponentTypeFullDto, ComponentType, Long>
        implements ComponentTypeController {

    private static final Logger logger = Logger.getLogger(ComponentTypeControllerImpl.class);
    private final ComponentTypeService service;
    private final MapperFacade mapper;

    @Autowired
    public ComponentTypeControllerImpl(ComponentTypeService componentTypeService, MapperFacade mapper) {
        super(componentTypeService, mapper, ComponentTypeBriefDto.class, ComponentTypeFullDto.class, ComponentType.class, logger);
        this.service = componentTypeService;
        this.mapper = mapper;
    }

    @Override
    public Iterable<ComponentModelBriefDto> getModels(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of models by ComponentType with id = [%s]", id));
        return StreamSupport.stream(wrapServiceCall(() -> service.getModels(id).spliterator(), logger), false)
                .map(i -> mapper.map(i, ComponentModelBriefDto.class))
                .collect(Collectors.toList());
    }
}
