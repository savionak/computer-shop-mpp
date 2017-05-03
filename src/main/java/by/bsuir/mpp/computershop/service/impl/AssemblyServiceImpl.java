package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.repository.AssemblyRepository;
import by.bsuir.mpp.computershop.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyServiceImpl extends AbstractCrudService<Assembly, Long> implements AssemblyService {

    @Autowired
    public AssemblyServiceImpl(AssemblyRepository assemblyRepository) {
        super(assemblyRepository);
    }

}
