package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.ComponentStoreBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentStoreFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/component/store")
public interface ComponentStoreController
        extends CrudController<ComponentStoreBriefDto, ComponentStoreFullDto, Long> {
}
