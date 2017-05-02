package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.OrderRepository;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.OrderService;
import by.bsuir.mpp.computershop.service.impl.OrderServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.OrderEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class OrderServiceTest extends CrudServiceTest<Order, Long> {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private OrderEntitySupplier orderEntitySupplier;

    public OrderServiceTest() {
        orderRepository = Mockito.mock(OrderRepository.class);
        orderService = new OrderServiceImpl(orderRepository);
        orderEntitySupplier = new OrderEntitySupplier();
    }

    @Override
    protected CrudService<Order, Long> getCrudService() {
        return orderService;
    }

    @Override
    protected PagingAndSortingRepository<Order, Long> getCrudRepository() {
        return orderRepository;
    }

    @Override
    protected EntitySupplier<Order, Long> getEntitySupplier() {
        return orderEntitySupplier;
    }
}
