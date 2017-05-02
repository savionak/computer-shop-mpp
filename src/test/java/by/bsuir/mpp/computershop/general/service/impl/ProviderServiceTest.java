package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.ProviderService;
import by.bsuir.mpp.computershop.service.impl.ProviderServiceImpl;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import by.bsuir.mpp.computershop.utils.entity.supplier.impl.ProviderEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ProviderServiceTest extends CrudServiceTest<Provider, Long>{

    private ProviderService providerService;
    private ProviderRepository providerRepository;
    private ProviderEntitySupplier providerEntitySupplier;

    public  ProviderServiceTest(){
        providerRepository= Mockito.mock(ProviderRepository.class);
        providerService = new ProviderServiceImpl(providerRepository) ;
        providerEntitySupplier =  new ProviderEntitySupplier();
    }

    @Override
    protected CrudService<Provider, Long> getCrudService() {
        return providerService;
    }

    @Override
    protected PagingAndSortingRepository<Provider, Long> getCrudRepository() {
        return providerRepository;
    }

    @Override
    protected EntitySupplier<Provider, Long> getEntitySupplier() {
        return providerEntitySupplier;
    }
}
