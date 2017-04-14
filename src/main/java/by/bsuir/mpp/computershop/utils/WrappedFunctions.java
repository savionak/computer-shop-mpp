package by.bsuir.mpp.computershop.utils;

import by.bsuir.mpp.computershop.service.exception.ServiceException;

public class WrappedFunctions {

    @FunctionalInterface
    public interface Function<T> {
        T call() throws ServiceException;
    }

    @FunctionalInterface
    public interface VoidFunction {
        void call() throws ServiceException;
    }
}
