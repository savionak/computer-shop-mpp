package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.repository.AssemblyComponentRepository;
import by.bsuir.mpp.computershop.service.AssemblyComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyComponentServiceImpl extends AbstractCrudService<AssemblyComponent, Long> implements AssemblyComponentService {

    @Autowired
    public AssemblyComponentServiceImpl(AssemblyComponentRepository assemblyComponentRepository) {
        super(assemblyComponentRepository);
    }

}
