package by.bsuir.mpp.computershop.utils;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErrorResponse {
    private List<ErrorResponse> errors = new ArrayList<>();

    public ValidationError(String message) {
        super(message);
    }

    public void addFieldError(CustomFieldError error) {
        this.errors.add(error);
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }
}
