package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.WithRemovedController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.PageDto;
import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.full.BaseFullDto;
import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.WithRemovedService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

public abstract class AbstractWithRemovedController
        <B extends BaseBriefDto<ID>, F extends BaseFullDto<ID>, E extends BaseEntity<ID>, ID extends Serializable>
        extends AbstractCrudController<B, F, E, ID>
        implements WithRemovedController<B, F, ID> {

    private final WithRemovedService<E, ID> service;
    private final Logger logger;
    private final MapperFacade mapper;
    private final Class<B> briefDtoClass;
    private final Class<F> fullDtoClass;
    private final Class<E> entityClass;

    AbstractWithRemovedController(WithRemovedService<E, ID> service,
                                  MapperFacade mapper,
                                  Class<B> briefDtoClass,
                                  Class<F> fullDtoClass,
                                  Class<E> entityClass,
                                  Logger logger) {
        super(service, mapper, briefDtoClass, fullDtoClass, entityClass, logger);
        this.service = service;
        this.mapper = mapper;
        this.briefDtoClass = briefDtoClass;
        this.fullDtoClass = fullDtoClass;
        this.entityClass = entityClass;
        this.logger = logger;
    }

    @Override
    public PageDto getRemoved(Pageable pageable) throws ControllerException {
        logger.info(String.format("GET REMOVED entities of %s", entityClass.toString()));
        Page<E> removed = wrapServiceCall(() -> service.getRemoved(pageable), logger);
        return asPageDto(removed, briefDtoClass);
    }

    @Override
    public void restore(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("RESTORE entity with id = [%s] of %s", id.toString(), entityClass.toString()));
        wrapServiceCall(() -> service.restore(id), logger);
    }
}
