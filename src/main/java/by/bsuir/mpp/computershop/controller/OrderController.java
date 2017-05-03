package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;
import by.bsuir.mpp.computershop.dto.full.OrderFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/order")
public interface OrderController
        extends CrudController<OrderBriefDto, OrderFullDto, Long> {
}
