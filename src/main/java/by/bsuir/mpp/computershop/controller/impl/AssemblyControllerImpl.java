package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.AssemblyController;
import by.bsuir.mpp.computershop.dto.brief.AssemblyBriefDto;
import by.bsuir.mpp.computershop.dto.full.AssemblyFullDto;
import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.service.AssemblyService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssemblyControllerImpl
        extends AbstractCrudController<AssemblyBriefDto, AssemblyFullDto, Assembly, Long>
        implements AssemblyController {

    private static final Logger logger = Logger.getLogger(AssemblyControllerImpl.class);

    @Autowired
    public AssemblyControllerImpl(AssemblyService assemblyService, MapperFacade mapper) {
        super(assemblyService, mapper, AssemblyBriefDto.class, AssemblyFullDto.class, Assembly.class, logger);
    }

}
