package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentModelServiceImpl extends AbstractCrudService<ComponentModel, Long> implements ComponentModelService {

    @Autowired
    public ComponentModelServiceImpl(ComponentModelRepository modelRepository) {
        super(modelRepository);
    }
}
