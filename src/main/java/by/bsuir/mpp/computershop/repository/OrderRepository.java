package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
