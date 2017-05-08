package by.bsuir.mpp.computershop.service.exception;

public class EntityOperationException extends ServiceException {
    public EntityOperationException() {
        super();
    }

    public EntityOperationException(Exception e) {
        super(e);
    }

    public EntityOperationException(String message) {
        super(message);
    }

    public EntityOperationException(String message, Exception e) {
        super(message, e);
    }
}
