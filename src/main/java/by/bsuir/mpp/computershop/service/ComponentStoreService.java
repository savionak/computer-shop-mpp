package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.dto.helper.UpdateStoredPriceDto;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.service.exception.ServiceException;

public interface ComponentStoreService extends CrudService<ComponentStore, Long> {

    void updateStorePrice(UpdateStoredPriceDto dto) throws ServiceException;

    Iterable<ComponentStore> getCurrentState() throws ServiceException;
}
