package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.entity.ComponentType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/componentType")
public interface ComponentTypeController extends CrudController<ComponentType, Long> {
}
