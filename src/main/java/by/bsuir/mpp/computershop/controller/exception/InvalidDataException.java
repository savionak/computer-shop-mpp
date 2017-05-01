package by.bsuir.mpp.computershop.controller.exception;

public class InvalidDataException extends ControllerException {

    public InvalidDataException(){
        super();
    }

    public InvalidDataException(Exception e){
        super(e);
    }

    public InvalidDataException(String message){
        super(message);
    }

    public InvalidDataException(String message, Exception e){
        super(message, e);
    }

}
