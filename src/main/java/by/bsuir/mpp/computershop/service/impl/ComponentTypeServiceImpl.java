package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class ComponentTypeServiceImpl extends AbstractCrudService<ComponentType, Long> implements ComponentTypeService {

    private ComponentTypeRepository typeRepository;

    @Autowired
    public ComponentTypeServiceImpl(ComponentTypeRepository typeRepository) {
        super(typeRepository);
        this.typeRepository = typeRepository;
    }

    @Override
    public Page<ComponentType> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> typeRepository.findAllByRemovedIsFalse(pageable));
    }

    @Override
    public Page<ComponentType> getRemoved(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> typeRepository.findAllByRemovedIsTrue(pageable));
    }

    @Override
    public void restore(Long id) throws ServiceException {
        wrapRepositoryCall(() -> typeRepository.restore(id));
    }
}
