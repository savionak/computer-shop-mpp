package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.repository.ImportRepository;
import by.bsuir.mpp.computershop.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportServiceImpl extends AbstractCrudService<Import, Long> implements ImportService {

    @Autowired
    public ImportServiceImpl(ImportRepository importRepository) {
        super(importRepository);
    }
}
