package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.AssemblyBriefDto;
import by.bsuir.mpp.computershop.dto.full.AssemblyFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/assembly")
public interface AssemblyController
        extends CrudController<AssemblyBriefDto, AssemblyFullDto, Long> {
}
