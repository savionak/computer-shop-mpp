package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
