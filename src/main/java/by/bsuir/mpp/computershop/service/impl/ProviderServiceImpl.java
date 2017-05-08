package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends AbstractSoftDeleteService<Provider, Long> implements ProviderService {

    private ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        super(providerRepository);
        this.providerRepository = providerRepository;
    }
}
