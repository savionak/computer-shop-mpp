package by.bsuir.mpp.computershop.controller.exception.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse extends TimestampErrorResponse {
    private List<ErrorResponse> errors = new ArrayList<>();

    public ValidationErrorResponse(String message) {
        super(message);
    }

    public void addFieldError(CustomFieldErrorResponse error) {
        this.errors.add(error);
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }
}
