package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.entity.Order;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/order")
public interface OrderController extends CrudController<Order, Long> {
}
