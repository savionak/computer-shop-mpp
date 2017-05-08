package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentTypeServiceImpl extends AbstractSoftDeleteService<ComponentType, Long>
        implements ComponentTypeService {

    private ComponentTypeRepository typeRepository;

    @Autowired
    public ComponentTypeServiceImpl(ComponentTypeRepository typeRepository) {
        super(typeRepository);
        this.typeRepository = typeRepository;
    }
}
