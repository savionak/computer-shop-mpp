package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProviderRepository extends PagingAndSortingRepository<Provider, Long> {

    @Override
    @Modifying
    @Query(value = "CALL remove_provider(:id);", nativeQuery = true)
    void delete(@Param("id") Long id);

    Page<Provider> findAllByRemovedIsFalse(Pageable pageable);

    Page<Provider> findAllByRemovedIsTrue(Pageable pageable);
}
