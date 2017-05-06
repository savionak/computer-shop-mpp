package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.ProviderService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class ProviderServiceImpl extends AbstractCrudService<Provider, Long> implements ProviderService {

    private ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        super(providerRepository);
        this.providerRepository = providerRepository;
    }

    @Override
    public Page<Provider> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> providerRepository.findAllByRemovedIsFalse(pageable));
    }

    @Override
    public Page<Provider> getRemoved(Pageable pageable) throws ServiceException{
        return wrapRepositoryCall(() -> providerRepository.findAllByRemovedIsTrue(pageable));
    }
}
