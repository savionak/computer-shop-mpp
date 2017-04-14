package by.bsuir.mpp.computershop.controller.exception.wrapper;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.utils.WrappedFunctions.Function;
import by.bsuir.mpp.computershop.utils.WrappedFunctions.VoidFunction;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.apache.log4j.Logger;

public class ServiceCallWrapper {
    public static <T> T wrapServiceCall(Function<T> func, Logger logger) throws ControllerException {
        T result;
        try {
            result = func.call();
        } catch (EntityNotFoundException e) {
            logger.warn(e);
            throw new ResourceNotFoundException(e);
        } catch (ServiceException e) {
            logger.warn(e);
            throw new ControllerException(e);
        }
        return result;
    }

    public static void wrapServiceCall(VoidFunction func, Logger logger) throws ControllerException {
        wrapServiceCall(() -> func, logger);
    }
}
