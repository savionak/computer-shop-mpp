package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.OrderController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;
import by.bsuir.mpp.computershop.dto.full.OrderFullDto;
import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.service.OrderService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class OrderControllerImpl
        extends AbstractCrudController<OrderBriefDto, OrderFullDto, Order, Long>
        implements OrderController {

    private static final Logger logger = Logger.getLogger(OrderControllerImpl.class);
    private final OrderService orderService;

    @Autowired
    public OrderControllerImpl(OrderService orderService, MapperFacade mapper) {
        super(orderService, mapper, OrderBriefDto.class, OrderFullDto.class, Order.class, logger);
        this.orderService = orderService;
    }

    @Override
    public void accept(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("ACCEPT Order with id = [%s]", id.toString()));
        wrapServiceCall(() -> orderService.accept(id), logger);
    }

    @Override
    public void startEdit(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("START EDIT Order with id = [%s]", id.toString()));
        wrapServiceCall(() -> orderService.startEdit(id), logger);
    }

    @Override
    public void finish(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("FINISH Order with id = [%s]", id.toString()));
        wrapServiceCall(() -> orderService.finish(id), logger);
    }

    @Override
    public void unfinish(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("UNFINISH Order with id = [%s]", id.toString()));
        wrapServiceCall(() -> orderService.unfinish(id), logger);
    }

    @Override
    public void cancel(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("CANCEK Order with id = [%s]", id.toString()));
        wrapServiceCall(() -> orderService.cancel(id), logger);
    }

    @Override
    public void renew(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("TRY RENEW Order with id = [%s]", id.toString()));
        wrapServiceCall(() -> orderService.renew(id), logger);
    }
}
