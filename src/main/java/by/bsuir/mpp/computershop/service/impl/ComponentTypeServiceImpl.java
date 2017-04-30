package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentTypeServiceImpl extends AbstractCrudService<ComponentType, Long> implements ComponentTypeService {

    @Autowired
    public ComponentTypeServiceImpl(ComponentTypeRepository typeRepository) {
        super(typeRepository);
    }

    @Override
    public Iterable<ComponentModel> getModels(Long id) throws ServiceException {
        return getOne(id).getModels();
    }
}
