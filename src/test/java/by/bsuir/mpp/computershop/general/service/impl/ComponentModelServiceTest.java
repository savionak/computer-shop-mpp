package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.impl.ComponentModelServiceImpl;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import by.bsuir.mpp.computershop.utils.entity.supplier.impl.ComponentModelEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ComponentModelServiceTest extends CrudServiceTest<ComponentModel, Long>{

    private ComponentModelService componentModelService;
    private ComponentModelRepository componentModelRepository;
    private ComponentModelEntitySupplier componentModelEntitySupplier;

    public ComponentModelServiceTest(){
        componentModelRepository= Mockito.mock(ComponentModelRepository.class);
        componentModelService = new ComponentModelServiceImpl(componentModelRepository) ;
        componentModelEntitySupplier =  new ComponentModelEntitySupplier();
    }

    @Override
    protected CrudService<ComponentModel, Long> getCrudService() {
        return componentModelService;
    }

    @Override
    protected PagingAndSortingRepository<ComponentModel, Long> getCrudRepository() {
        return componentModelRepository;
    }

    @Override
    protected EntitySupplier<ComponentModel, Long> getEntitySupplier() {
        return componentModelEntitySupplier;
    }
}
