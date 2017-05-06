package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentModelController;
import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentModelFullDto;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentModelControllerImpl
        extends AbstractWithRemovedController<ComponentModelBriefDto, ComponentModelFullDto, ComponentModel, Long>
        implements ComponentModelController {

    private static final Logger logger = Logger.getLogger(ComponentModelControllerImpl.class);
    private final ComponentModelService service;
    private final MapperFacade mapper;

    @Autowired
    public ComponentModelControllerImpl(ComponentModelService componentModelService, MapperFacade mapper) {
        super(componentModelService, mapper, ComponentModelBriefDto.class, ComponentModelFullDto.class, ComponentModel.class, logger);
        service = componentModelService;
        this.mapper = mapper;
    }
}
