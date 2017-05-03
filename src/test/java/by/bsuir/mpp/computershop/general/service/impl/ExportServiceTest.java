package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Export;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.ExportRepository;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.ExportService;
import by.bsuir.mpp.computershop.service.impl.ExportServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.ExportEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ExportServiceTest extends CrudServiceTest<Export, Long> {

    private ExportService exportService;
    private ExportRepository exportRepository;
    private ExportEntitySupplier exportEntitySupplier;

    public ExportServiceTest() {
        exportRepository = Mockito.mock(ExportRepository.class);
        exportService = new ExportServiceImpl(exportRepository);
        exportEntitySupplier = new ExportEntitySupplier();
    }

    @Override
    protected CrudService<Export, Long> getCrudService() {
        return exportService;
    }

    @Override
    protected PagingAndSortingRepository<Export, Long> getCrudRepository() {
        return exportRepository;
    }

    @Override
    protected EntitySupplier<Export, Long> getEntitySupplier() {
        return exportEntitySupplier;
    }
}
