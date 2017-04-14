package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.ProviderService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends AbstractCrudService<Provider, Long> implements ProviderService {

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        super(providerRepository);
    }

    @Override
    public Iterable<Import> getImports(Long id) throws ServiceException {
        return getOne(id).getImports();
    }
}
