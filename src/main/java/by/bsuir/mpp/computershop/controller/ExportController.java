package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.ExportBriefDto;
import by.bsuir.mpp.computershop.dto.full.ExportFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/export")
public interface ExportController
        extends CrudController<ExportBriefDto, ExportFullDto, Long> {
}
