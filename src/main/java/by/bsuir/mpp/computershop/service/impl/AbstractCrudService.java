package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.BadEntityException;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

public abstract class AbstractCrudService<E extends BaseEntity<ID>, ID extends Serializable> implements CrudService<E, ID> {
    private static final String ID_NOT_FOUND_FORMAT_STRING = "Entity with id = [%s] not found";

    private PagingAndSortingRepository<E, ID> repository;

    AbstractCrudService(PagingAndSortingRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    public E add(E entity) throws ServiceException {
        if (!validateAdd(entity)) {
            throw new BadEntityException();
        }

        entity.setId(null); // to avoid update existing entities
        E result = wrapRepositoryCall(() -> repository.save(entity));

        if (result == null) {
            throw new ServiceException("Can't add entity.");
        }
        return result;
    }

    @Override
    public E update(E entity) throws ServiceException {
        ID id = entity.getId();
        if (id == null || !repository.exists(id) || !validateUpdate(entity)) {
            throw new BadEntityException(idNotFoundMessage(id));
        }

        E result = wrapRepositoryCall(() -> repository.save(entity));

        if (result == null) {
            throw new ServiceException("Can't update entity.");
        }
        return result;
    }

    @Override
    public Page<E> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> repository.findAll(pageable));
    }

    @Override
    public E getOne(ID id) throws ServiceException {
        E result = wrapRepositoryCall(() -> repository.findOne(id));
        if (result == null) {
            throw new EntityNotFoundException(idNotFoundMessage(id));
        }
        return result;
    }

    @Override
    public void delete(ID id) throws ServiceException {
        if (id == null || !repository.exists(id)) {
            throw new EntityNotFoundException(idNotFoundMessage(id));
        }
        wrapRepositoryCall(() -> repository.delete(id));
    }

    protected boolean validateAdd(E entity) {
        // check constraints before insert
        return true;
    }

    protected boolean validateUpdate(E entity) {
        // check constraints before update
        return true;
    }

    private String idNotFoundMessage(ID id) {
        return String.format(ID_NOT_FOUND_FORMAT_STRING, idToString(id));
    }

    private String idToString(ID id) {
        return id != null ? id.toString() : "null";
    }
}
