package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.entity.ComponentStore;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/component/store")
public interface ComponentStoreController extends CrudController<ComponentStore, Long> {
}
