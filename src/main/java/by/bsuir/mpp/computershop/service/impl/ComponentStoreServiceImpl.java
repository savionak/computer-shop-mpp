package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.ComponentStoreRepository;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentStoreServiceImpl extends AbstractCrudService<ComponentStore, Long> implements ComponentStoreService {

    private ComponentModelRepository modelRepository;

    @Autowired
    public ComponentStoreServiceImpl(ComponentStoreRepository storeRepository,
                                     ComponentModelRepository modelRepository) {
        super(storeRepository);
        this.modelRepository = modelRepository;
    }

    @Override
    protected boolean checkKeys(ComponentStore entity) {
        Long newModelId = entity.getNewModelId();
        return newModelId != null && modelRepository.exists(newModelId);
    }

    @Override
    protected void updateReferences(ComponentStore entity) {
        Long newModelId = entity.getNewModelId();
        entity.setComponentModel(modelRepository.findOne(newModelId));
    }
}
