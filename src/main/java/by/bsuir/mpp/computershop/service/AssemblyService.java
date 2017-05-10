package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssemblyService extends CrudService<Assembly, Long> {

    Page<Assembly> getListByOrderId(Long orderId, Pageable pageable) throws ServiceException;
}
