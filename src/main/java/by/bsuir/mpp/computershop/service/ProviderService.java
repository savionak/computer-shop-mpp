package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProviderService extends CrudService<Provider, Long> {

    Page<Provider> getRemoved(Pageable pageable) throws ServiceException;
}
