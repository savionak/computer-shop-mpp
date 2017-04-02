package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.CrudController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
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
        logger.info(String.format("ADD new %s entity", entity.getClass()));
        E result;
        try {
            result = service.add(entity);
        } catch (EntityNotFoundException e) {
            logger.error(e.getMessage());
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public E update(@RequestBody E entity) throws ControllerException {
        logger.info(String.format("UPDATE entity with id = [%s]", entity.getId()));
        E result;
        try {
            result = service.update(entity);
        } catch (EntityNotFoundException e) {
            logger.error(e.getMessage());
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public E getById(@PathVariable ID id) throws ControllerException {
        logger.info(String.format("GET entity with id = [%s]", id.toString()));
        E result;
        try {
            result = service.getOne(id);
        } catch (EntityNotFoundException e) {
            logger.error(e.getMessage());
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public Iterable<E> getAll() throws ControllerException {
        logger.info("GET ALL entities.");
        Iterable<E> result;
        try {
            result = service.getAll();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ControllerException(e);
        }
        return result;
    }

    @Override
    public void delete(@PathVariable ID id) throws ControllerException {
        logger.info(String.format("DELETE entity with id = [%s]", id.toString()));
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            logger.error(e.getMessage());
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ControllerException(e);
        }
    }
}
