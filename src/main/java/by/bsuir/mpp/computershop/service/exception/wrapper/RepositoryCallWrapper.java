package by.bsuir.mpp.computershop.service.exception.wrapper;

import by.bsuir.mpp.computershop.service.exception.BadEntityException;
import by.bsuir.mpp.computershop.service.exception.EntityOperationException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import by.bsuir.mpp.computershop.service.exception.wrapper.WrappedRepositoryFunctions.RepositoryFunction;
import by.bsuir.mpp.computershop.service.exception.wrapper.WrappedRepositoryFunctions.VoidRepositoryFunction;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

public class RepositoryCallWrapper {
    public static <T> T wrapRepositoryCall(RepositoryFunction<T> func) throws ServiceException {
        T result;
        try {
            result = func.call();
        } catch (DataIntegrityViolationException e) {
            throw new BadEntityException(e);
        } catch (DataAccessException e) {
            if (isUserSqlException(e)) {
                throw new EntityOperationException("FORBIDDEN");
            }
            throw new ServiceException(e);
        }
        return result;
    }

    public static void wrapRepositoryCall(VoidRepositoryFunction func) throws ServiceException {
        wrapRepositoryCall(() -> {
            func.call();
            return null;
        });
    }

    private static boolean isUserSqlException(Exception e) {
        Throwable cause = e.getCause();
        return (cause instanceof GenericJDBCException) &&
                ((GenericJDBCException) cause).getSQLState().startsWith("45");
    }
}
