package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentStoreController;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentStoreControllerImpl extends AbstractCrudController<ComponentStore, Long> implements ComponentStoreController {

    private static final Logger logger = Logger.getLogger(ComponentStoreControllerImpl.class);

    @Autowired
    public ComponentStoreControllerImpl(ComponentStoreService storeService) {
        super(storeService, logger);
    }
}