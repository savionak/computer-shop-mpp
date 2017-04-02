package by.bsuir.mpp.computershop.service.exception;

public class EntityNotFoundException extends ServiceException {
    private static final long serialVersionUID = 201L;
    private static final String ID_NOT_FOUND_FORMAT_STRING = "Entity with id = [%s] not found";

    public EntityNotFoundException(){
    }

    public EntityNotFoundException(Exception e){
        super(e);
    }

    public EntityNotFoundException(String message){
        super(String.format(ID_NOT_FOUND_FORMAT_STRING, message));
    }

    public EntityNotFoundException(String message, Exception e){
        super(message, e);
    }
}
