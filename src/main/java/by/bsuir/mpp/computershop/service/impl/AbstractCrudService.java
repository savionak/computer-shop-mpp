package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class AbstractCrudService<E extends BaseEntity<ID>, ID extends Serializable> implements CrudService<E, ID> {
    private static final String ID_NOT_FOUND_FORMAT_STRING = "Entity with id = [%s] not found";

    private CrudRepository<E, ID> repository;

    AbstractCrudService(CrudRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    public E add(E entity) throws ServiceException {
        entity.setId(null); // to avoid update existing entities
        try {
            return repository.save(entity);
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public E update(E entity) throws ServiceException {
        ID id = entity.getId();
        E result;
        try {
            if (id != null && repository.exists(id)) {
                result = repository.save(entity);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
            if (result == null) {
                throw new ServiceException("Can't update entity.");
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Iterable<E> getAll() throws ServiceException {
        Iterable<E> result;
        try {
            result =  repository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public E getOne(ID id) throws ServiceException {
        E result = null;
        try {
            if (id != null) {
                result = repository.findOne(id);
            }
            if (result == null) {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public void delete(ID id) throws ServiceException {
        try{
            if (id != null && repository.exists(id)) {
                repository.delete(id);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
    }

    String idNotFoundMessage(ID id) {
        return String.format(ID_NOT_FOUND_FORMAT_STRING, idToString(id));
    }

    private String idToString(ID id) {
        return id != null ? id.toString() : "null";
    }
}
