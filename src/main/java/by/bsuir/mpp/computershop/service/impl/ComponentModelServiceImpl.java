package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentModelServiceImpl extends AbstractCrudService<ComponentModel, Long> implements ComponentModelService {

    @Autowired
    public ComponentModelServiceImpl(ComponentModelRepository modelRepository) {
        super(modelRepository);
    }

    @Override
    public Iterable<Import> getImports(Long id) throws ServiceException {
        return getOne(id).getImports();
    }

    @Override
    public Iterable<ComponentStore> getStored(Long id) throws ServiceException {
        return getOne(id).getStoredComponents();
    }
}
