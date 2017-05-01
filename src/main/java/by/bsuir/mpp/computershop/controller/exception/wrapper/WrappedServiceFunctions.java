package by.bsuir.mpp.computershop.controller.exception.wrapper;

import by.bsuir.mpp.computershop.service.exception.ServiceException;

public class WrappedServiceFunctions {

    @FunctionalInterface
    public interface ServiceFunction<T> {
        T call() throws ServiceException;
    }

    @FunctionalInterface
    public interface VoidServiceFunction {
        void call() throws ServiceException;
    }
}
