package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.repository.OrderRepository;
import by.bsuir.mpp.computershop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractCrudService<Order, Long> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

}
