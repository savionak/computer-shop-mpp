package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.ImportRepository;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.ImportService;
import by.bsuir.mpp.computershop.service.impl.ImportServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.ImportEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ImportServiceTest extends CrudServiceTest<Import, Long> {

    private ImportService importService;
    private ImportRepository importRepository;
    private ImportEntitySupplier importEntitySupplier;

    public ImportServiceTest() {
        importRepository = Mockito.mock(ImportRepository.class);
        importService = new ImportServiceImpl(importRepository);
        importEntitySupplier = new ImportEntitySupplier();
    }

    @Override
    protected CrudService<Import, Long> getCrudService() {
        return importService;
    }

    @Override
    protected PagingAndSortingRepository<Import, Long> getCrudRepository() {
        return importRepository;
    }

    @Override
    protected EntitySupplier<Import, Long> getEntitySupplier() {
        return importEntitySupplier;
    }
}
