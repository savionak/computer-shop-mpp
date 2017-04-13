package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.entity.ComponentModel;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/componentModel")
public interface ComponentModelController extends CrudController<ComponentModel, Long> {
}
