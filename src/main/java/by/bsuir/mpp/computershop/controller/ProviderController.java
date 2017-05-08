package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.dto.brief.ProviderBriefDto;
import by.bsuir.mpp.computershop.dto.full.ProviderFullDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/provider")
public interface ProviderController
        extends SoftDeleteController<ProviderBriefDto, ProviderFullDto, Long> {
}
