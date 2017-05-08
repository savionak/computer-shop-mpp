package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.general.service.SoftDeleteServiceTest;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.impl.ComponentModelServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.ComponentModelEntitySupplier;
import org.mockito.Mockito;


public class ComponentModelServiceTest extends SoftDeleteServiceTest<ComponentModel, Long> {

    private ComponentModelService componentModelService;
    private ComponentModelRepository componentModelRepository;
    private ComponentModelEntitySupplier componentModelEntitySupplier;

    public ComponentModelServiceTest() {
        componentModelRepository = Mockito.mock(ComponentModelRepository.class);
        componentModelService = new ComponentModelServiceImpl(componentModelRepository);
        componentModelEntitySupplier = new ComponentModelEntitySupplier();
    }

    @Override
    protected SoftDeleteService<ComponentModel, Long> getCrudService() {
        return componentModelService;
    }

    @Override
    protected SoftDeleteRepository<ComponentModel, Long> getCrudRepository() {
        return componentModelRepository;
    }

    @Override
    protected EntitySupplier<ComponentModel, Long> getEntitySupplier() {
        return componentModelEntitySupplier;
    }
}
