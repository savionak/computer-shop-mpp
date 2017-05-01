package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public abstract class AbstractCrudService<E extends BaseEntity<ID>, ID extends Serializable> implements CrudService<E, ID> {
    private static final String ID_NOT_FOUND_FORMAT_STRING = "Entity with id = [%s] not found";

    private PagingAndSortingRepository<E, ID> repository;

    AbstractCrudService(PagingAndSortingRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public E add(E entity) throws ServiceException {
        entity.setId(null); // to avoid update existing entities
        E result;
        try {
            if (checkKeys(entity)) {
                updateReferences(entity);
            } else {
                throw new EntityNotFoundException("Referenced entities not found");
            }
            result = repository.save(entity);
            if (result == null) {
                throw new ServiceException("Can't add entity.");
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    @Transactional
    public E update(E entity) throws ServiceException {
        ID id = entity.getId();
        E result;
        try {
            if (id != null && repository.exists(id)
                    && checkKeys(entity)) {
                updateReferences(entity);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
            result = repository.save(entity);
            if (result == null) {
                throw new ServiceException("Can't update entity.");
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Page<E> getAll(Pageable pageable) throws ServiceException {
        Page<E> result;
        try {
            result = repository.findAll(pageable);
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
        try {
            if (id != null && repository.exists(id)) {
                repository.delete(id);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
    }

    protected boolean checkKeys(E entity) {
        // check foreign keys before insert/update
        return true;
    }

    protected void updateReferences(E entity) {
        // assign entity references
    }

    private String idNotFoundMessage(ID id) {
        return String.format(ID_NOT_FOUND_FORMAT_STRING, idToString(id));
    }

    private String idToString(ID id) {
        return id != null ? id.toString() : "null";
    }
}
