package by.bsuir.mpp.computershop.service.exception;

public class BadEntityException extends ServiceException {

    public BadEntityException() {

    }

    public BadEntityException(Exception e) {
        super(e);
    }

    public BadEntityException(String message) {
        super(message);
    }

    public BadEntityException(String message, Exception e) {
        super(message, e);
    }
}
