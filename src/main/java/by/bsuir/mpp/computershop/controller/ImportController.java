package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.entity.Import;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/import")
public interface ImportController extends CrudController<Import, Long> {
}
