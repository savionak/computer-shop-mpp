package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public interface CrudService<E extends BaseEntity<ID>, ID extends Serializable> {

    @Transactional
    E add(E entity) throws ServiceException;

    @Transactional
    E update(E entity) throws ServiceException;

    Iterable<E> getAll() throws ServiceException;

    E getOne(ID id) throws ServiceException;

    void delete(ID id) throws ServiceException;
}
