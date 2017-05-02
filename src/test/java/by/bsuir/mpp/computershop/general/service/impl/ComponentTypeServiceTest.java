package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.impl.ComponentTypeServiceImpl;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import by.bsuir.mpp.computershop.utils.entity.supplier.impl.ComponentTypeEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ComponentTypeServiceTest extends CrudServiceTest<ComponentType, Long>{

    private ComponentTypeService componentTypeService;
    private ComponentTypeRepository componentTypeRepository;
    private ComponentTypeEntitySupplier componentTypeEntitySupplier;

    public ComponentTypeServiceTest(){
        componentTypeRepository= Mockito.mock(ComponentTypeRepository.class);
        componentTypeService = new ComponentTypeServiceImpl(componentTypeRepository) ;
        componentTypeEntitySupplier =  new ComponentTypeEntitySupplier();
    }

    @Override
    protected CrudService<ComponentType, Long> getCrudService() {
        return componentTypeService;
    }

    @Override
    protected PagingAndSortingRepository<ComponentType, Long> getCrudRepository() {
        return componentTypeRepository;
    }

    @Override
    protected EntitySupplier<ComponentType, Long> getEntitySupplier() {
        return componentTypeEntitySupplier;
    }
}
