package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ExportController;
import by.bsuir.mpp.computershop.dto.brief.ExportBriefDto;
import by.bsuir.mpp.computershop.dto.full.ExportFullDto;
import by.bsuir.mpp.computershop.entity.Export;
import by.bsuir.mpp.computershop.service.ExportService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExportControllerImpl
        extends AbstractCrudController<ExportBriefDto, ExportFullDto, Export, Long>
        implements ExportController {

    private static final Logger logger = Logger.getLogger(ExportControllerImpl.class);

    @Autowired
    public ExportControllerImpl(ExportService exportService, MapperFacade mapper) {
        super(exportService, mapper, ExportBriefDto.class, ExportFullDto.class, Export.class, logger);
    }

}
