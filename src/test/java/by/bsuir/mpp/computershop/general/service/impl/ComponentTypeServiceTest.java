package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.general.service.SoftDeleteServiceTest;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.service.ComponentTypeService;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.impl.ComponentTypeServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.ComponentTypeEntitySupplier;
import org.mockito.Mockito;


public class ComponentTypeServiceTest extends SoftDeleteServiceTest<ComponentType, Long> {

    private ComponentTypeService componentTypeService;
    private ComponentTypeRepository componentTypeRepository;
    private ComponentTypeEntitySupplier componentTypeEntitySupplier;

    public ComponentTypeServiceTest() {
        componentTypeRepository = Mockito.mock(ComponentTypeRepository.class);
        componentTypeService = new ComponentTypeServiceImpl(componentTypeRepository);
        componentTypeEntitySupplier = new ComponentTypeEntitySupplier();
    }

    @Override
    protected SoftDeleteService<ComponentType, Long> getCrudService() {
        return componentTypeService;
    }

    @Override
    protected SoftDeleteRepository<ComponentType, Long> getCrudRepository() {
        return componentTypeRepository;
    }

    @Override
    protected EntitySupplier<ComponentType, Long> getEntitySupplier() {
        return componentTypeEntitySupplier;
    }
}
