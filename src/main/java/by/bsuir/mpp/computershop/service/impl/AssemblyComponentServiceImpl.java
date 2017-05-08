package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.repository.AssemblyComponentRepository;
import by.bsuir.mpp.computershop.service.AssemblyComponentService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class AssemblyComponentServiceImpl extends AbstractCrudService<AssemblyComponent, Long> implements AssemblyComponentService {

    private final AssemblyComponentRepository componentRepository;

    @Autowired
    public AssemblyComponentServiceImpl(AssemblyComponentRepository assemblyComponentRepository) {
        super(assemblyComponentRepository);
        this.componentRepository = assemblyComponentRepository;
    }

    @Override
    public Page<AssemblyComponent> getByAssemblyId(Long assemblyId, Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> componentRepository.findAllByAssemblyId(assemblyId, pageable));
    }
}
