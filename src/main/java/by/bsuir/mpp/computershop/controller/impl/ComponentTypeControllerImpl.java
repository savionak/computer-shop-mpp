package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentTypeController;
import by.bsuir.mpp.computershop.dto.brief.ComponentTypeBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentTypeFullDto;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentTypeControllerImpl
        extends AbstractWithRemovedController<ComponentTypeBriefDto, ComponentTypeFullDto, ComponentType, Long>
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

}
