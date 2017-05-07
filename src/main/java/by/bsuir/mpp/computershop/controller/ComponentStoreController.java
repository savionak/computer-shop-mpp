package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.full.ComponentStoreFullDto;
import by.bsuir.mpp.computershop.dto.helper.UpdateStoredPriceDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/component/store")
public interface ComponentStoreController
        extends ReadController<ComponentStoreFullDto, Long> {

    @RequestMapping(value = "update/price", method = RequestMethod.POST)
    void updateStorePrice(@RequestBody UpdateStoredPriceDto updateStoredPriceDto) throws ControllerException;
}
