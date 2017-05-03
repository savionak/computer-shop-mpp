package by.bsuir.mpp.computershop.service.exception.wrapper;

import org.springframework.dao.DataAccessException;

public class WrappedRepositoryFunctions {

    @FunctionalInterface
    public interface RepositoryFunction<T> {
        T call() throws DataAccessException;
    }

    @FunctionalInterface
    public interface VoidRepositoryFunction {
        void call() throws DataAccessException;
    }
}
