package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ProviderController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.service.ProviderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class ProviderControllerImpl extends AbstractCrudController<Provider, Long>
        implements ProviderController {

    private static final Logger logger = Logger.getLogger(ProviderControllerImpl.class);
    private final ProviderService service;

    @Autowired
    public ProviderControllerImpl(ProviderService providerService) {
        super(providerService, logger);
        this.service = providerService;
    }

    @Override
    public Iterable<Import> getImports(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of imports by Provider with id = [%s]", id));
        return wrapServiceCall(() -> service.getImports(id), logger);
    }
}
