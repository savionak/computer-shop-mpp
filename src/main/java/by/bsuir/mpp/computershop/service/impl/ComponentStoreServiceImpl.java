package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.dto.helper.UpdateStoredPriceDto;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.repository.ComponentStoreRepository;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class ComponentStoreServiceImpl extends AbstractCrudService<ComponentStore, Long> implements ComponentStoreService {

    private final ComponentStoreRepository storeRepository;

    @Autowired
    public ComponentStoreServiceImpl(ComponentStoreRepository storeRepository) {
        super(storeRepository);
        this.storeRepository = storeRepository;
    }

    @Override
    public void updateStorePrice(UpdateStoredPriceDto dto) throws ServiceException {
        Long id = dto.getId();
        Long newPrice = dto.getNewPrice();
        Long newCount = dto.getNewCount();
        wrapRepositoryCall(() -> storeRepository.updateStorePrice(id, newPrice, newCount));
    }
}
