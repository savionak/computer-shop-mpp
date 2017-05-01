package by.bsuir.mpp.computershop.service.exception;

public class EntityNotFoundException extends ServiceException {

    public EntityNotFoundException(){

    }

    public EntityNotFoundException(Exception e){
        super(e);
    }

    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message, Exception e){
        super(message, e);
    }
}
