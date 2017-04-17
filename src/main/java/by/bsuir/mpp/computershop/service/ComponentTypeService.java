package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.service.exception.ServiceException;

public interface ComponentTypeService extends CrudService<ComponentType, Long> {

    Iterable<ComponentModel> getModels(Long id) throws ServiceException;
}
