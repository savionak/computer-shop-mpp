package by.bsuir.mpp.computershop.controller.exception.dto;

public class CustomFieldErrorResponse extends ErrorResponse {
    private String field;

    public CustomFieldErrorResponse(String message) {
        super(message);
    }

    public CustomFieldErrorResponse(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
