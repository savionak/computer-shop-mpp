package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Customer;
import by.bsuir.mpp.computershop.general.service.SoftDeleteServiceTest;
import by.bsuir.mpp.computershop.repository.CustomerRepository;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.service.CustomerService;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.impl.CustomerServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.CustomerEntitySupplier;
import org.mockito.Mockito;


public class CustomerServiceTest extends SoftDeleteServiceTest<Customer, Long> {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerEntitySupplier customerEntitySupplier;

    public CustomerServiceTest() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
        customerEntitySupplier = new CustomerEntitySupplier();
    }

    @Override
    protected SoftDeleteService<Customer, Long> getCrudService() {
        return customerService;
    }

    @Override
    protected SoftDeleteRepository<Customer, Long> getCrudRepository() {
        return customerRepository;
    }

    @Override
    protected EntitySupplier<Customer, Long> getEntitySupplier() {
        return customerEntitySupplier;
    }
}
