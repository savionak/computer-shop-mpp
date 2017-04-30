package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.ImportBriefDto;
import by.bsuir.mpp.computershop.dto.full.ImportFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/import")
public interface ImportController
        extends CrudController<ImportBriefDto, ImportFullDto, Long> {
}
