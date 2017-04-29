package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.CrudController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.BaseDto;
import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

public abstract class AbstractCrudController<E extends BaseEntity<ID>, ID extends Serializable>
        implements CrudController<E, ID> {

    private final CrudService<E, ID> service;
    private final Logger logger;
    private final MapperFacade mapper;
    private final Class<? extends BaseBriefDto> briefDtoClass;

    AbstractCrudController(CrudService<E, ID> service,
                           MapperFacade mapper,
                           Class<? extends BaseBriefDto> briefDtoClass,
                           Logger logger) {
        this.service = service;
        this.mapper = mapper;
        this.briefDtoClass = briefDtoClass;
        this.logger = logger;
    }

    @Override
    public E add(@Valid @RequestBody E entity) throws ControllerException {
        logger.info(String.format("ADD new %s entity", entity.getClass()));
        return wrapServiceCall(() -> service.add(entity), logger);
    }

    @Override
    public E update(@Valid @RequestBody E entity) throws ControllerException {
        logger.info(String.format("UPDATE entity with id = [%s]", entity.getId()));
        return wrapServiceCall(() -> service.update(entity), logger);
    }

    @Override
    public E getById(@PathVariable ID id) throws ControllerException {
        logger.info(String.format("GET entity with id = [%s]", id.toString()));
        return wrapServiceCall(() -> service.getOne(id), logger);
    }

    @Override
    public Iterable<BaseDto> getAll() throws ControllerException {
        logger.info("GET ALL entities.");
        Iterable<E> all = wrapServiceCall(service::getAll, logger);
        return StreamSupport.stream(all.spliterator(), false)
                .map(i -> mapper.map(i, briefDtoClass))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(@PathVariable ID id) throws ControllerException {
        logger.info(String.format("DELETE entity with id = [%s]", id.toString()));
        wrapServiceCall(() -> service.delete(id), logger);
    }
}
