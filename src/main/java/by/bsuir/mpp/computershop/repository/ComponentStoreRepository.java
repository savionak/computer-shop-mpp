package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.ComponentStore;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ComponentStoreRepository extends PagingAndSortingRepository<ComponentStore, Long> {

    @Transactional
    @Modifying
    @Query(value = "CALL update_store_price(:id, :new_price, :new_count);", nativeQuery = true)
    void updateStorePrice(@Param("id") Long id, @Param("new_price") Long newPrice, @Param("new_count") Long newCount);
}
