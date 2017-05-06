package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class ComponentModelServiceImpl extends AbstractCrudService<ComponentModel, Long> implements ComponentModelService {

    private final ComponentModelRepository modelRepository;

    @Autowired
    public ComponentModelServiceImpl(ComponentModelRepository modelRepository) {
        super(modelRepository);
        this.modelRepository = modelRepository;
    }

    @Override
    public Page<ComponentModel> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> modelRepository.findAllByRemovedIsFalse(pageable));
    }

    @Override
    public Page<ComponentModel> getRemoved(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> modelRepository.findAllByRemovedIsTrue(pageable));
    }

    @Override
    public void restore(Long id) throws ServiceException {
        wrapRepositoryCall(() -> modelRepository.restore(id));
    }
}
