package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.ComponentType;

public interface ComponentTypeService {
    ComponentType add(ComponentType type);
    Iterable<ComponentType> getAll();
    ComponentType getOne(Long id);
    void delete(Long id);
    ComponentType update(ComponentType type);
}
