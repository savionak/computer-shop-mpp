package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.AssemblyRepository;
import by.bsuir.mpp.computershop.service.AssemblyService;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.impl.AssemblyServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.AssemblyEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class AssemblyServiceTest extends CrudServiceTest<Assembly, Long> {

    private AssemblyService assemblyService;
    private AssemblyRepository assemblyRepository;
    private AssemblyEntitySupplier assemblyEntitySupplier;

    public AssemblyServiceTest() {
        assemblyRepository = Mockito.mock(AssemblyRepository.class);
        assemblyService = new AssemblyServiceImpl(assemblyRepository);
        assemblyEntitySupplier = new AssemblyEntitySupplier();
    }

    @Override
    protected CrudService<Assembly, Long> getCrudService() {
        return assemblyService;
    }

    @Override
    protected PagingAndSortingRepository<Assembly, Long> getCrudRepository() {
        return assemblyRepository;
    }

    @Override
    protected EntitySupplier<Assembly, Long> getEntitySupplier() {
        return assemblyEntitySupplier;
    }
}
