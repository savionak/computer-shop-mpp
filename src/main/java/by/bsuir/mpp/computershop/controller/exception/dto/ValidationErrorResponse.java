package by.bsuir.mpp.computershop.controller.exception.dto;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse extends ErrorResponse {
    private List<CustomFieldError> errors = new ArrayList<>();

    public ValidationErrorResponse(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public void addFieldError(CustomFieldError error) {
        this.errors.add(error);
    }

    public List<CustomFieldError> getErrors() {
        return errors;
    }
}
