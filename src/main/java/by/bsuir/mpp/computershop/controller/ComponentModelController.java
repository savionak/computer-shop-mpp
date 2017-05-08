package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentModelFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/component/model")
public interface ComponentModelController
        extends SoftDeleteController<ComponentModelBriefDto, ComponentModelFullDto, Long> {
}
