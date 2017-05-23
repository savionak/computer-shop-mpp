package by.bsuir.mpp.computershop.controller.exception.wrapper;

import by.bsuir.mpp.computershop.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public class WrappedServiceFunctions {

    @FunctionalInterface
    public interface ServiceFunction<T> {
        T call() throws ServiceException;
    }

    @FunctionalInterface
    public interface VoidServiceFunction {
        void call() throws ServiceException;
    }

    @FunctionalInterface
    public interface DocumentGeneratorCall {
        void call() throws DocumentException, IOException;
    }
}
