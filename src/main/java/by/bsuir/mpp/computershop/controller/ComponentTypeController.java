package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.ComponentTypeBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentTypeFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/component/type")
public interface ComponentTypeController
        extends SoftDeleteController<ComponentTypeBriefDto, ComponentTypeFullDto, Long> {
}
