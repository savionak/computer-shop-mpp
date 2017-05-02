package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.AssemblyComponentRepository;
import by.bsuir.mpp.computershop.service.AssemblyComponentService;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.impl.AssemblyComponentServiceImpl;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import by.bsuir.mpp.computershop.utils.entity.supplier.impl.AssemblyComponentEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class AssemblyComponentServiceTest extends CrudServiceTest<AssemblyComponent, Long>{

    private AssemblyComponentService assemblyComponentService;
    private AssemblyComponentRepository assemblyComponentRepository;
    private AssemblyComponentEntitySupplier assemblyComponentEntitySupplier;

    public AssemblyComponentServiceTest(){
        assemblyComponentRepository= Mockito.mock(AssemblyComponentRepository.class);
        assemblyComponentService = new AssemblyComponentServiceImpl(assemblyComponentRepository) ;
        assemblyComponentEntitySupplier =  new AssemblyComponentEntitySupplier();
    }

    @Override
    protected CrudService<AssemblyComponent, Long> getCrudService() {
        return assemblyComponentService;
    }

    @Override
    protected PagingAndSortingRepository<AssemblyComponent, Long> getCrudRepository() {
        return assemblyComponentRepository;
    }

    @Override
    protected EntitySupplier<AssemblyComponent, Long> getEntitySupplier() {
        return assemblyComponentEntitySupplier;
    }
}
