package by.bsuir.mpp.computershop.controller.exception.dto;

import org.springframework.http.HttpStatus;

public class NumberErrorResponse extends ErrorResponse{
    private ErrorNumber errorNumber;

    public NumberErrorResponse(String message) {
        super(message, HttpStatus.BAD_REQUEST);
        this.errorNumber = ErrorNumber.SERVER_ERROR;
    }

    public NumberErrorResponse(String message, ErrorNumber number) {
        super(message, HttpStatus.BAD_REQUEST);
        this.errorNumber = number;
    }

    public ErrorNumber getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(ErrorNumber number) {
        this.errorNumber = number;
    }

    public enum ErrorNumber {
        SERVER_ERROR,
        CONSTRAINTS_ERROR
    }
}
