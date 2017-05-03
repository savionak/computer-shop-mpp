package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
