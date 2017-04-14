package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.ImportRepository;
import by.bsuir.mpp.computershop.repository.ProviderRepository;
import by.bsuir.mpp.computershop.service.ImportService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ImportServiceImpl extends AbstractCrudService<Import, Long> implements ImportService {

    private ImportRepository importRepository;
    private ComponentModelRepository componentModelRepository;
    private ProviderRepository providerRepository;

    @Autowired
    public ImportServiceImpl(ImportRepository importRepository,
                             ProviderRepository providerRepository,
                             ComponentModelRepository modelRepository) {
        super(importRepository);
        this.importRepository = importRepository;
        this.componentModelRepository = modelRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public Import add(Import entity) throws ServiceException {
        entity.setId(null); // to avoid update existing entities
        Long providerId = entity.getNewProviderId();
        Long modelId = entity.getNewModelId();
        Import result;
        try {
            if (providerId != null && providerRepository.exists(providerId)
                    && modelId != null && componentModelRepository.exists((modelId))) {
                Provider newProvider = providerRepository.findOne(providerId);
                entity.setProvider(newProvider);
                ComponentModel newModel = componentModelRepository.findOne(modelId);
                entity.setModel(newModel);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(providerId));
            }
            result = importRepository.save(entity);
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Import update(Import entity) throws ServiceException {
        Long id = entity.getId();
        Long providerId = entity.getNewProviderId();
        Long modelId = entity.getNewModelId();
        Import result;
        try {
            if (id != null && importRepository.exists(id)
                    && providerId != null && providerRepository.exists(providerId)
                    && modelId != null && componentModelRepository.exists((modelId))) {
                Provider newProvider = providerRepository.findOne(providerId);
                entity.setProvider(newProvider);
                ComponentModel newModel = componentModelRepository.findOne(modelId);
                entity.setModel(newModel);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
            result = importRepository.save(entity);
            if (result == null) {
                throw new ServiceException("Can't update entity.");
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

}
