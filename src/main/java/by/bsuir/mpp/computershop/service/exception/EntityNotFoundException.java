package by.bsuir.mpp.computershop.service.exception;

public class EntityNotFoundException extends ServiceException {
    private static final long serialVersionUID = 201L;

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
