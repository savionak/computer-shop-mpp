package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.CrudController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.full.BaseFullDto;
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
    private final Class<? extends BaseFullDto> fullDtoClass;
    private Class<E> entityClass;

    AbstractCrudController(CrudService<E, ID> service,
                           MapperFacade mapper,
                           Class<? extends BaseBriefDto> briefDtoClass,
                           Class<? extends BaseFullDto> fullDtoClass,
                           Class<E> entityClass,
                           Logger logger) {
        this.service = service;
        this.mapper = mapper;
        this.briefDtoClass = briefDtoClass;
        this.fullDtoClass = fullDtoClass;
        this.entityClass = entityClass;
        this.logger = logger;
    }

    @Override
    public BaseFullDto add(@Valid @RequestBody BaseFullDto dto) throws ControllerException {
        logger.info(String.format("ADD new %s entity", dto.getClass()));
        E entity = mapper.map(dto, entityClass);
        E resultEntity = wrapServiceCall(() -> service.add(entity), logger);
        return mapper.map(resultEntity, fullDtoClass);
    }

    @Override
    public BaseFullDto update(@Valid @RequestBody BaseFullDto dto) throws ControllerException {
        logger.info(String.format("UPDATE entity with id = [%s]", dto.getId()));
        E entity = mapper.map(dto, entityClass);
        E resultEntity = wrapServiceCall(() -> service.update(entity), logger);
        return mapper.map(resultEntity, fullDtoClass);
    }

    @Override
    public BaseFullDto getById(@PathVariable ID id) throws ControllerException {
        logger.info(String.format("GET entity with id = [%s]", id.toString()));
        E resultEntity = wrapServiceCall(() -> service.getOne(id), logger);
        return mapper.map(resultEntity, fullDtoClass);
    }

    @Override
    public Iterable<BaseBriefDto> getAll() throws ControllerException {
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
