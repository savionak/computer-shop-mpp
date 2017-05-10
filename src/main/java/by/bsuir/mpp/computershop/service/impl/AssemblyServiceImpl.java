package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.repository.AssemblyRepository;
import by.bsuir.mpp.computershop.service.AssemblyService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class AssemblyServiceImpl extends AbstractCrudService<Assembly, Long> implements AssemblyService {

    private final AssemblyRepository assemblyRepository;

    @Autowired
    public AssemblyServiceImpl(AssemblyRepository assemblyRepository) {
        super(assemblyRepository);
        this.assemblyRepository = assemblyRepository;
    }

    @Override
    public Page<Assembly> getListByOrderId(Long orderId, Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> assemblyRepository.findAllByOrderId(orderId, pageable));
    }
}
