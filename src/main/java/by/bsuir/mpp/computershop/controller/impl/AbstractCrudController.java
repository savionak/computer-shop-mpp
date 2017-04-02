package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.CrudController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public abstract class AbstractCrudController<E extends BaseEntity<ID>, ID extends Serializable> implements CrudController<E, ID> {
    private final CrudService<E, ID> service;
    private Logger logger;

    AbstractCrudController(CrudService<E, ID> service, Logger logger) {
        this.service = service;
        this.logger = logger;
    }

    @Override
    public E add(@RequestBody E entity) throws ControllerException {
        E result;
        try {
            logger.info(String.format("ADD new %s entity", entity.getClass()));
            result = service.add(entity);
        } catch (ServiceException e) {
            logger.warn("Can't add new entity.");
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public E update(@RequestBody E entity) throws ControllerException {
        E result;
        try {
            logger.info(String.format("UPDATE entity with id = [%s]", entity.getId()));
            result = service.update(entity);
        } catch (ServiceException e) {
            logger.warn(String.format("Can't update entity with id = [%s]", entity.getId().toString()));
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public E getById(@PathVariable ID id) throws ControllerException {
        E result;
        try {
            logger.info(String.format("GET entity with id = [%s]", id.toString()));
            result = service.getOne(id);
        } catch (ServiceException e) {
            logger.warn(String.format("Can't get entity with id = [%s]", id.toString()));
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public Iterable<E> getAll() throws ControllerException {
        Iterable<E> result;
        try {
            result = service.getAll();
        } catch (ServiceException e) {
            logger.warn("Can't get all entities.");
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public void delete(@PathVariable ID id) throws ControllerException {
        try {
            logger.info(String.format("DELETE entity with id = [%s]", id.toString()));
            service.delete(id);
        } catch (ServiceException e) {
            logger.warn(String.format("Can't delete entity with id = [%s]", id.toString()));
            throw new ControllerException(e);
        }
    }
}
