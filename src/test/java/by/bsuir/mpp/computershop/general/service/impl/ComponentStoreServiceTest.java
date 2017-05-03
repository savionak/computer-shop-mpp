package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.ComponentStoreRepository;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.impl.ComponentStoreServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.ComponentStoreEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ComponentStoreServiceTest extends CrudServiceTest<ComponentStore, Long> {

    private ComponentStoreService componentStoreService;
    private ComponentStoreRepository componentStoreRepository;
    private ComponentStoreEntitySupplier componentStoreEntitySupplier;

    public ComponentStoreServiceTest() {
        componentStoreRepository = Mockito.mock(ComponentStoreRepository.class);
        componentStoreService = new ComponentStoreServiceImpl(componentStoreRepository);
        componentStoreEntitySupplier = new ComponentStoreEntitySupplier();
    }

    @Override
    protected CrudService<ComponentStore, Long> getCrudService() {
        return componentStoreService;
    }

    @Override
    protected PagingAndSortingRepository<ComponentStore, Long> getCrudRepository() {
        return componentStoreRepository;
    }

    @Override
    protected EntitySupplier<ComponentStore, Long> getEntitySupplier() {
        return componentStoreEntitySupplier;
    }
}
