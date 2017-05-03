package by.bsuir.mpp.computershop.controller.exception.dto;

import java.sql.Timestamp;

public class TimestampErrorResponse extends ErrorResponse {

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public TimestampErrorResponse(String message) {
        super(message);
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
