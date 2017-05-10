package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Assembly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AssemblyRepository extends PagingAndSortingRepository<Assembly, Long> {

    Page<Assembly> findAllByOrderId(Long assemblyId, Pageable pageable);
}
