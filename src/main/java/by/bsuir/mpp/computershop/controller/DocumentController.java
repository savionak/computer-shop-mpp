package by.bsuir.mpp.computershop.controller;


import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.document.DocumentType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("api/documents")
public interface DocumentController {

    @RequestMapping(path = "store", method = RequestMethod.GET)
    void exportComponentStore(
            @RequestParam("type") DocumentType documentType,
            HttpServletResponse response) throws ControllerException;
}
