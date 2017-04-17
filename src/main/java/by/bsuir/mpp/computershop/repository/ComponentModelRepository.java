package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import org.springframework.data.repository.CrudRepository;

public interface ComponentModelRepository extends CrudRepository<ComponentModel, Long> {
    Iterable<ComponentModel> getComponentModelsByType(ComponentType type);
}
