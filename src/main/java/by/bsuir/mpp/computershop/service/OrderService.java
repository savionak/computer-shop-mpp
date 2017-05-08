package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.service.exception.ServiceException;

public interface OrderService extends CrudService<Order, Long> {

    void accept(Long id) throws ServiceException;

    void startEdit(Long id) throws ServiceException;

    void finish(Long id) throws ServiceException;

    void unfinish(Long id) throws ServiceException;

    void cancel(Long id) throws ServiceException;

    void renew(Long id) throws ServiceException;
}
