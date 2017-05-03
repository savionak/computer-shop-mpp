package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Export;
import by.bsuir.mpp.computershop.repository.ExportRepository;
import by.bsuir.mpp.computershop.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportServiceImpl extends AbstractCrudService<Export, Long> implements ExportService {

    @Autowired
    public ExportServiceImpl(ExportRepository exportRepository) {
        super(exportRepository);
    }

}
