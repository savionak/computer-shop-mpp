package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Customer;
import by.bsuir.mpp.computershop.repository.CustomerRepository;
import by.bsuir.mpp.computershop.service.CustomerService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class CustomerServiceImpl extends AbstractCrudService<Customer, Long> implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> customerRepository.findAllByRemovedIsFalse(pageable));
    }

    @Override
    public Page<Customer> getRemoved(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> customerRepository.findAllByRemovedIsTrue(pageable));
    }

    @Override
    public void restore(Long id) throws ServiceException {
        wrapRepositoryCall(() -> customerRepository.restore(id));
    }
}
