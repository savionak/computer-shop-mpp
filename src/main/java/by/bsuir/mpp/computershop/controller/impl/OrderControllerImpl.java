package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.OrderController;
import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerImpl extends AbstractCrudController<Order, Long> implements OrderController {

    private static final Logger logger = Logger.getLogger(OrderControllerImpl.class);

    @Autowired
    public OrderControllerImpl(OrderService orderService) {
        super(orderService, logger);
    }
}