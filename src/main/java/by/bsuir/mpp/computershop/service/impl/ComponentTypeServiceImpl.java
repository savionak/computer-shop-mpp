package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentTypeServiceImpl extends AbstractCrudService<ComponentType, Long> implements ComponentTypeService {

    private final ComponentTypeRepository typeRepository;
    private ComponentModelRepository modelRepository;

    @Autowired
    public ComponentTypeServiceImpl(ComponentTypeRepository typeRepository,
                                    ComponentModelRepository modelRepository) {
        super(typeRepository);  // for general use
        this.modelRepository = modelRepository; // for specific use
        this.typeRepository = typeRepository; // for specific use
    }

    @Override
    public Iterable<ComponentModel> getModels(Long id) throws ServiceException {
        return modelRepository.getComponentModelsByType(typeRepository.findOne(id));
    }
}
