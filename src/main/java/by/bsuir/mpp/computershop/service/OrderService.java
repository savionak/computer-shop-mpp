package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService extends CrudService<Order, Long> {

    void accept(Long id) throws ServiceException;

    void startEdit(Long id) throws ServiceException;

    void cancel(Long id) throws ServiceException;

    void renew(Long id) throws ServiceException;

    Page<Order> getCanceled(Pageable pageable) throws ServiceException;
}
