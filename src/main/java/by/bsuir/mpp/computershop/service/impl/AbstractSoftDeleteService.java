package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.BaseSoftEntity;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class AbstractSoftDeleteService<E extends BaseSoftEntity<ID>, ID extends Serializable>
        extends AbstractCrudService<E, ID> implements SoftDeleteService<E, ID> {

    private SoftDeleteRepository<E, ID> repository;

    @Autowired
    public AbstractSoftDeleteService(SoftDeleteRepository<E, ID> repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<E> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> repository.findAllByRemovedIsFalse(pageable));
    }

    @Override
    public Page<E> getRemoved(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> repository.findAllByRemovedIsTrue(pageable));
    }

    @Override
    public void restore(ID id) throws ServiceException {
        wrapRepositoryCall(() -> repository.restore(id));
    }
}
