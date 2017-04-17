package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.service.exception.ServiceException;

public interface ProviderService extends CrudService<Provider, Long> {

    Iterable<Import> getImports(Long id) throws ServiceException;
}
