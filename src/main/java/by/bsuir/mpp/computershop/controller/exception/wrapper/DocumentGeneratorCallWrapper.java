package by.bsuir.mpp.computershop.controller.exception.wrapper;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public class DocumentGeneratorCallWrapper {
    public static void wrapDocumentGeneratorCall(WrappedServiceFunctions.DocumentGeneratorCall documentGeneratorCall) throws ControllerException {
        try {
            documentGeneratorCall.call();
        } catch (IOException | DocumentException e) {
            throw new ControllerException(e);
        }
    }
}
