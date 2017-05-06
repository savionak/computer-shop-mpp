package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderRepository extends PagingAndSortingRepository<Provider, Long> {

    Page<Provider> findAllByRemovedIsFalse(Pageable pageable);

    Page<Provider> findAllByRemovedIsTrue(Pageable pageable);
}
