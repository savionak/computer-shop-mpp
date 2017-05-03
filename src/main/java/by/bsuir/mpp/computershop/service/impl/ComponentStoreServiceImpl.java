package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.repository.ComponentStoreRepository;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentStoreServiceImpl extends AbstractCrudService<ComponentStore, Long> implements ComponentStoreService {

    @Autowired
    public ComponentStoreServiceImpl(ComponentStoreRepository storeRepository) {
        super(storeRepository);
    }
}
