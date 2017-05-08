package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.CustomerBriefDto;
import by.bsuir.mpp.computershop.dto.full.CustomerFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/customer")
public interface CustomerController
        extends SoftDeleteController<CustomerBriefDto, CustomerFullDto, Long> {
}
