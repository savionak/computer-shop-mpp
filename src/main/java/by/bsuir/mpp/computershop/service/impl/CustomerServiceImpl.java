package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Customer;
import by.bsuir.mpp.computershop.repository.CustomerRepository;
import by.bsuir.mpp.computershop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends AbstractSoftDeleteService<Customer, Long> implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }
}
