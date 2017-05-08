package by.bsuir.mpp.computershop.controller.exception.wrapper;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.InvalidDataException;
import by.bsuir.mpp.computershop.controller.exception.OperationException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.controller.exception.wrapper.WrappedServiceFunctions.ServiceFunction;
import by.bsuir.mpp.computershop.controller.exception.wrapper.WrappedServiceFunctions.VoidServiceFunction;
import by.bsuir.mpp.computershop.service.exception.BadEntityException;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.EntityOperationException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.apache.log4j.Logger;

public class ServiceCallWrapper {
    public static <T> T wrapServiceCall(ServiceFunction<T> func, Logger logger) throws ControllerException {
        T result;
        try {
            result = func.call();
        } catch (EntityNotFoundException e) {
            logger.warn(e);
            throw new ResourceNotFoundException(e);
        } catch (BadEntityException e) {
            logger.warn(e);
            throw new InvalidDataException(e);
        } catch (EntityOperationException e) {
            logger.warn(e);
            throw new OperationException(e);
        } catch (ServiceException e) {
            logger.warn(e);
            throw new ControllerException(e);
        }
        return result;
    }

    public static void wrapServiceCall(VoidServiceFunction func, Logger logger) throws ControllerException {
        wrapServiceCall(() -> {
            func.call();
            return null;
        }, logger);
    }
}
