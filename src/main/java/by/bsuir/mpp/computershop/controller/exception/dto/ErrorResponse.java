package by.bsuir.mpp.computershop.controller.exception.dto;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ErrorResponse {
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
