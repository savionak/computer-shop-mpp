package by.bsuir.mpp.computershop.controller.exception.dto;

import java.sql.Timestamp;

public class ErrorResponse {

    private String message;

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
