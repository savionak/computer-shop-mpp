package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.service.exception.ServiceException;

public interface ComponentModelService extends CrudService<ComponentModel, Long> {
    Iterable<Import> getImports(Long id) throws ServiceException;
    Iterable<ComponentStore> getStored(Long id) throws ServiceException;
}
