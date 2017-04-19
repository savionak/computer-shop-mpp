package by.bsuir.mpp.computershop.controller.exception;

public class ResourceNotFoundException extends ControllerException {
    private static final long serialVersionUID = 101L;

    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(Exception e){
        super(e);
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Exception e){
        super(message, e);
    }
}
