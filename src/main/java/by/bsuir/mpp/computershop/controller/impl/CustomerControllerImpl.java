package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.CustomerController;
import by.bsuir.mpp.computershop.dto.brief.CustomerBriefDto;
import by.bsuir.mpp.computershop.dto.full.CustomerFullDto;
import by.bsuir.mpp.computershop.entity.Customer;
import by.bsuir.mpp.computershop.service.CustomerService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerImpl
        extends AbstractWithRestoreController<CustomerBriefDto, CustomerFullDto, Customer, Long>
        implements CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerControllerImpl.class);

    @Autowired
    public CustomerControllerImpl(CustomerService customerService, MapperFacade mapper) {
        super(customerService, mapper, CustomerBriefDto.class, CustomerFullDto.class, Customer.class, logger);
    }

}
