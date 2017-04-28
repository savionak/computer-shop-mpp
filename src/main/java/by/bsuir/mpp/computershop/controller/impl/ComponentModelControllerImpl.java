package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentModelController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.dto.ImportDto;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class ComponentModelControllerImpl extends AbstractCrudController<ComponentModel, Long>
        implements ComponentModelController {

    private static final Logger logger = Logger.getLogger(ComponentModelControllerImpl.class);
    private ComponentModelService service;

    @Autowired
    public ComponentModelControllerImpl(ComponentModelService componentModelService) {
        super(componentModelService, logger);
        service = componentModelService;
    }

    @Override
    public Iterable<ImportDto> getImports(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of imports by id = [%s]", id));
        Iterable<Import> imports = wrapServiceCall(() -> service.getImports(id), logger);
        return StreamSupport.stream(imports.spliterator(), false)
                .map(Import::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<ComponentStore> getStoredItems(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of stored items by id = [%s]", id));
        return wrapServiceCall(() -> service.getStored(id), logger);
    }
}
