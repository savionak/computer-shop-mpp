package by.bsuir.mpp.computershop.service.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 101L;
    private static final String ID_NOT_FOUND_FORMAT_STRING = "Entity with id = [%s] not found";

    public ServiceException(){
    }

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }

    public static String getNotFoundMessage(String id) {
        return String.format(ID_NOT_FOUND_FORMAT_STRING, id);
    }
}
