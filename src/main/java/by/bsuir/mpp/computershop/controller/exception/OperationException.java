package by.bsuir.mpp.computershop.controller.exception;

public class OperationException extends ControllerException {
    public OperationException() {
        super();
    }

    public OperationException(Exception e) {
        super(e);
    }

    public OperationException(String message) {
        super(message);
    }

    public OperationException(String message, Exception e) {
        super(message, e);
    }
}
