package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.ImportBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ProviderBriefDto;
import by.bsuir.mpp.computershop.dto.full.ProviderFullDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/provider")
public interface ProviderController
        extends CrudController<ProviderBriefDto, ProviderFullDto, Long> {

    @RequestMapping(path = "{id}/imports", method = RequestMethod.GET)
    Iterable<ImportBriefDto> getImports(@PathVariable Long id) throws ControllerException;
}
