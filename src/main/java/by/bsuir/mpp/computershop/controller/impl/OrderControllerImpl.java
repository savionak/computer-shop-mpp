package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.OrderController;
import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;
import by.bsuir.mpp.computershop.dto.full.OrderFullDto;
import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.service.OrderService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerImpl
        extends AbstractCrudController<OrderBriefDto, OrderFullDto, Order, Long>
        implements OrderController {

    private static final Logger logger = Logger.getLogger(OrderControllerImpl.class);

    @Autowired
    public OrderControllerImpl(OrderService orderService, MapperFacade mapper) {
        super(orderService, mapper, OrderBriefDto.class, OrderFullDto.class, Order.class, logger);
    }
}
