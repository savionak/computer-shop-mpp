package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentTypeServiceImpl extends AbstractCrudService<ComponentType, Long> implements ComponentTypeService {

//    private ComponentTypeRepository repository;   // concrete repository

    @Autowired
    public ComponentTypeServiceImpl(ComponentTypeRepository repository) {
        super(repository);  // for general use
//        this.repository = repository; // for specific use
    }

}
