package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssemblyComponentService extends CrudService<AssemblyComponent, Long> {

    Page<AssemblyComponent> getByAssemblyId(Long assemblyId, Pageable pageable) throws ServiceException;
}
