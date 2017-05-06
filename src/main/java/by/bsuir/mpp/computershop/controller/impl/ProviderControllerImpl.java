package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ProviderController;
import by.bsuir.mpp.computershop.dto.brief.ProviderBriefDto;
import by.bsuir.mpp.computershop.dto.full.ProviderFullDto;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.service.ProviderService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderControllerImpl
        extends AbstractWithRestoreController<ProviderBriefDto, ProviderFullDto, Provider, Long>
        implements ProviderController {

    private static final Logger logger = Logger.getLogger(ProviderControllerImpl.class);

    @Autowired
    public ProviderControllerImpl(ProviderService providerService, MapperFacade mapper) {
        super(providerService, mapper, ProviderBriefDto.class, ProviderFullDto.class, Provider.class, logger);
    }

}
