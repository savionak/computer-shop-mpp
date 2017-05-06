package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ComponentModelRepository extends PagingAndSortingRepository<ComponentModel, Long> {

    @Override
    @Transactional
    @Modifying
    @Query(value = "CALL remove_model(:id);", nativeQuery = true)
    void delete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL restore_model(:id);", nativeQuery = true)
    void restore(@Param("id") Long id);

    Page<ComponentModel> findAllByRemovedIsFalse(Pageable pageable);

    Page<ComponentModel> findAllByRemovedIsTrue(Pageable pageable);
}
