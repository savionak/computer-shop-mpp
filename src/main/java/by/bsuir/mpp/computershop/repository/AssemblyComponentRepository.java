package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AssemblyComponentRepository extends PagingAndSortingRepository<AssemblyComponent, Long> {

    Page<AssemblyComponent> findAllByAssemblyId(Long assemblyId, Pageable pageable);
}
