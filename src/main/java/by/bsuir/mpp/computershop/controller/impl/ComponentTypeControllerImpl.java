package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentTypeController;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentTypeControllerImpl extends AbstractCrudController<ComponentType, Long> implements ComponentTypeController {

    private static final Logger logger = Logger.getLogger(ComponentTypeControllerImpl.class);

    @Autowired
    public ComponentTypeControllerImpl(ComponentTypeService componentTypeService) {
        super(componentTypeService, logger);
    }

}
