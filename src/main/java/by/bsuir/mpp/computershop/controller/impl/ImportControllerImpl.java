package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ImportController;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.service.ImportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportControllerImpl extends AbstractCrudController<Import, Long>
        implements ImportController {

    private static final Logger logger = Logger.getLogger(ImportControllerImpl.class);

    @Autowired
    public ImportControllerImpl(ImportService importService) {
        super(importService, logger);
    }
}
