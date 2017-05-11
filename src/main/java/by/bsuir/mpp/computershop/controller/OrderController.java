package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;
import by.bsuir.mpp.computershop.dto.full.OrderFullDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/order")
public interface OrderController
        extends CrudController<OrderBriefDto, OrderFullDto, Long> {

    @RequestMapping(path = "accept/{id}", method = RequestMethod.POST)
    void accept(@PathVariable Long id) throws ControllerException;

    @RequestMapping(path = "start_edit/{id}", method = RequestMethod.POST)
    void startEdit(@PathVariable Long id) throws ControllerException;

    @RequestMapping(path = "cancel/{id}", method = RequestMethod.POST)
    void cancel(@PathVariable Long id) throws ControllerException;

    @RequestMapping(path = "renew/{id}", method = RequestMethod.POST)
    void renew(@PathVariable Long id) throws ControllerException;
}
