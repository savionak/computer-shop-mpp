package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class AbstractCrudService<E extends BaseEntity<ID>, ID extends Serializable> implements CrudService<E, ID> {

    private CrudRepository<E, ID> repository;

    AbstractCrudService(CrudRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    public E add(E entity) throws ServiceException {
        entity.setId(null); // to avoid update existing entities
        return repository.save(entity);
    }

    @Override
    public E update(E entity) throws ServiceException {
        ID id = entity.getId();
        E result = null;
        if (repository.exists(id)) {
            result = repository.save(entity);
        }
        if (result == null) {
            throw new ServiceException("Can't update entity.");
        }
        return result;
    }

    @Override
    public Iterable<E> getAll() throws ServiceException {
        return repository.findAll();
    }

    @Override
    public E getOne(ID id) throws ServiceException {
        E result;
        result = repository.findOne(id);
        if (result == null) {
            throw new ServiceException(ServiceException.getNotFoundMessage(id.toString()));
        }
        return result;
    }

    @Override
    public void delete(ID id) throws ServiceException {
        if (repository.exists(id)) {
            repository.delete(id);
        } else {
            throw new ServiceException(ServiceException.getNotFoundMessage(id.toString()));
        }
    }
}
