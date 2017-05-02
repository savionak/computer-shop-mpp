package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Customer;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.CustomerRepository;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.CustomerService;
import by.bsuir.mpp.computershop.service.impl.CustomerServiceImpl;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import by.bsuir.mpp.computershop.utils.entity.supplier.impl.CustomerEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class CustomerServiceTest extends CrudServiceTest<Customer, Long>{

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerEntitySupplier customerEntitySupplier;

    public CustomerServiceTest(){
        customerRepository= Mockito.mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository) ;
        customerEntitySupplier =  new CustomerEntitySupplier();
    }

    @Override
    protected CrudService<Customer, Long> getCrudService() {
        return customerService;
    }

    @Override
    protected PagingAndSortingRepository<Customer, Long> getCrudRepository() {
        return customerRepository;
    }

    @Override
    protected EntitySupplier<Customer, Long> getEntitySupplier() {
        return customerEntitySupplier;
    }
}
