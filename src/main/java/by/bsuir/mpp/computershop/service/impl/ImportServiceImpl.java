package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.ImportRepository;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportServiceImpl extends AbstractCrudService<Import, Long> implements ImportService {

    private ComponentModelRepository modelRepository;
    private ProviderRepository providerRepository;

    @Autowired
    public ImportServiceImpl(ImportRepository importRepository,
                             ProviderRepository providerRepository,
                             ComponentModelRepository modelRepository) {
        super(importRepository);
        this.modelRepository = modelRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    protected boolean checkKeys(Import entity) {
        Long newProviderId = entity.getNewProviderId();
        Long newModelId = entity.getNewModelId();
        return newProviderId != null && providerRepository.exists(newProviderId)
                && newModelId != null && modelRepository.exists(newModelId);
    }

    @Override
    protected void updateReferences(Import entity) {
        Long newProviderId = entity.getNewProviderId();
        Long newModelId = entity.getNewModelId();
        entity.setProvider(providerRepository.findOne(newProviderId));
        entity.setModel(modelRepository.findOne(newModelId));
    }
}
