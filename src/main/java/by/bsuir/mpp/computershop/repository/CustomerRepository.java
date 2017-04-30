package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
