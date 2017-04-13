package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentTypeController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentTypeControllerImpl extends AbstractCrudController<ComponentType, Long> implements ComponentTypeController {

    private static final Logger logger = Logger.getLogger(ComponentTypeControllerImpl.class);
    private final ComponentTypeService service;

    @Autowired
    public ComponentTypeControllerImpl(ComponentTypeService componentTypeService) {
        super(componentTypeService, logger);
        this.service = componentTypeService;
    }

    @Override
    public Iterable<ComponentModel> getModels(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of models by ComponentType with id = [%s]", id));
        try {
            return service.getModels(id);
        } catch (EntityNotFoundException e) {
            logger.warn(e);
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.warn(e);
            throw new ControllerException(e);
        }
    }
}
