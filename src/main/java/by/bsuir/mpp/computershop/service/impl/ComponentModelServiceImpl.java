package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.entity.Import;
import by.bsuir.mpp.computershop.repository.ComponentModelRepository;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import by.bsuir.mpp.computershop.service.ComponentModelService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ComponentModelServiceImpl extends AbstractCrudService<ComponentModel, Long> implements ComponentModelService {

    private ComponentModelRepository modelRepository;
    private ComponentTypeRepository typeRepository;

    @Autowired
    public ComponentModelServiceImpl(ComponentModelRepository modelRepository, ComponentTypeRepository typeRepository) {
        super(modelRepository);
        this.modelRepository = modelRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public ComponentModel add(ComponentModel entity) throws ServiceException {
        entity.setId(null); // to avoid update existing entities
        Long typeId = entity.getNewTypeId();
        ComponentModel result;
        try {
            if (typeId != null && typeRepository.exists(typeId)) {
                ComponentType newType = typeRepository.findOne(typeId);
                entity.setType(newType);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(typeId));
            }
            result = modelRepository.save(entity);
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public ComponentModel update(ComponentModel entity) throws ServiceException {
        Long id = entity.getId();
        Long typeId = entity.getNewTypeId();
        ComponentModel result;
        try {
            if (id != null && modelRepository.exists(id)
                    && typeId != null && typeRepository.exists(typeId)) {
                ComponentType newType = typeRepository.findOne(typeId);
                entity.setType(newType);
                result = modelRepository.save(entity);
            } else {
                throw new EntityNotFoundException(idNotFoundMessage(id));
            }
            if (result == null) {
                throw new ServiceException("Can't update entity.");
            }
        } catch (DataAccessException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Iterable<Import> getImports(Long id) throws ServiceException {
        return getOne(id).getImports();
    }
}
