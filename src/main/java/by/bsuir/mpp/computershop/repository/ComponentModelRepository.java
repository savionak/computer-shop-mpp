package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import by.bsuir.mpp.computershop.entity.ComponentType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComponentModelRepository extends PagingAndSortingRepository<ComponentModel, Long> {
    Iterable<ComponentModel> getComponentModelsByType(ComponentType type);
}
