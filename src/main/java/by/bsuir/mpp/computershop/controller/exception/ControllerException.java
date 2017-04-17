package by.bsuir.mpp.computershop.controller.exception;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 100L;

    public ControllerException(){
    }

    public ControllerException(Exception e){
        super(e);
    }

    public ControllerException(String message){
        super(message);
    }

    public ControllerException(String message, Exception e){
        super(message, e);
    }
}
