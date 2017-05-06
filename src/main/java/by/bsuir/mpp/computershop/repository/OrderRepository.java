package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    @Transactional
    @Modifying
    @Query(value = "CALL computer_shop.accept_order(:id)", nativeQuery = true)
    void accept(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL start_edit_order(:id)", nativeQuery = true)
    void startEdit(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL finish_order(:id)", nativeQuery = true)
    void finish(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL unfinish_order(:id)", nativeQuery = true)
    void unfinish(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL cancel_order(:id)", nativeQuery = true)
    void cancel(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL renew_order(:id)", nativeQuery = true)
    void renew(@Param("id") Long id);
}
