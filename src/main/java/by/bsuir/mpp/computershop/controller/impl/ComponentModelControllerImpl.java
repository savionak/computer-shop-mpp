package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentModelController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentModelControllerImpl extends AbstractCrudController<ComponentModel, Long> implements ComponentModelController {

    private static final Logger logger = Logger.getLogger(ComponentModelControllerImpl.class);
    private ComponentModelService service;

    @Autowired
    public ComponentModelControllerImpl(ComponentModelService componentModelService) {
        super(componentModelService, logger);
        service = componentModelService;
    }

    @Override
    public Iterable<Import> getImports(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of imports by Provider with id = [%s]", id));
        try {
            return service.getImports(id);
        } catch (EntityNotFoundException e) {
            logger.warn(e);
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.warn(e);
            throw new ControllerException(e);
        }
    }
}
