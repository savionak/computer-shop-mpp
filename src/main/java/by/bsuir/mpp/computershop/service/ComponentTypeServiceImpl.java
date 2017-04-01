package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.ComponentType;
import by.bsuir.mpp.computershop.repository.ComponentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentTypeServiceImpl implements ComponentTypeService {
    private final ComponentTypeRepository repository;

    @Autowired
    public ComponentTypeServiceImpl(ComponentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ComponentType add(ComponentType type) {
        return repository.save(type);
    }

    @Override
    public Iterable<ComponentType> getAll() {
        return repository.findAll();
    }

    @Override
    public ComponentType getOne(Long id) {
        return repository.findOne(id);
    }


    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public ComponentType update(ComponentType type) {
        ComponentType result = null;
        ComponentType typeToUpdate = repository.findOne(type.getId());
        if (typeToUpdate != null) {
            result = repository.save(type);
        } else {
            System.out.println("Can't find component type with id = {" + type.getId() + "} to update.");
        }
        return result;
    }
}
