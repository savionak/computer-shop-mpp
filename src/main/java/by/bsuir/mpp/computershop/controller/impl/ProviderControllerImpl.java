package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ProviderController;
import by.bsuir.mpp.computershop.controller.WithRemovedController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.PageDto;
import by.bsuir.mpp.computershop.dto.brief.ProviderBriefDto;
import by.bsuir.mpp.computershop.dto.full.ProviderFullDto;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.service.ProviderService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class ProviderControllerImpl
        extends AbstractCrudController<ProviderBriefDto, ProviderFullDto, Provider, Long>
        implements ProviderController,
        WithRemovedController {

    private static final Logger logger = Logger.getLogger(ProviderControllerImpl.class);
    private final ProviderService service;
    private final MapperFacade mapper;

    @Autowired
    public ProviderControllerImpl(ProviderService providerService, MapperFacade mapper) {
        super(providerService, mapper, ProviderBriefDto.class, ProviderFullDto.class, Provider.class, logger);
        this.service = providerService;
        this.mapper = mapper;
    }

    @Override
    public PageDto getRemoved(Pageable pageable) throws ControllerException {
        logger.info("GET REMOVED Providers");
        Page<Provider> removed = wrapServiceCall(() -> service.getRemoved(pageable), logger);
        return asPageDto(removed, ProviderBriefDto.class);
    }
}
