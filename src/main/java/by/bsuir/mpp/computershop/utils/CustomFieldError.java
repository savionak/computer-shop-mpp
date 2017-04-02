package by.bsuir.mpp.computershop.utils;

public class CustomFieldError extends ErrorResponse {
    private String field;

    public CustomFieldError(String message) {
        super(message);
    }

    public CustomFieldError(String field, String message) {
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
