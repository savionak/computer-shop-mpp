package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.general.service.SoftDeleteServiceTest;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.service.ProviderService;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.impl.ProviderServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.ProviderEntitySupplier;
import org.mockito.Mockito;


public class ProviderServiceTest extends SoftDeleteServiceTest<Provider, Long> {

    private ProviderService providerService;
    private ProviderRepository providerRepository;
    private ProviderEntitySupplier providerEntitySupplier;

    public ProviderServiceTest() {
        providerRepository = Mockito.mock(ProviderRepository.class);
        providerService = new ProviderServiceImpl(providerRepository);
        providerEntitySupplier = new ProviderEntitySupplier();
    }

    @Override
    protected SoftDeleteService<Provider, Long> getCrudService() {
        return providerService;
    }

    @Override
    protected SoftDeleteRepository<Provider, Long> getCrudRepository() {
        return providerRepository;
    }

    @Override
    protected EntitySupplier<Provider, Long> getEntitySupplier() {
        return providerEntitySupplier;
    }
}
