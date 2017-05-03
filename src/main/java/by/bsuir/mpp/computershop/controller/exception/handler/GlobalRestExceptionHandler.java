package by.bsuir.mpp.computershop.controller.exception.handler;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.InvalidDataException;
import by.bsuir.mpp.computershop.controller.exception.ResourceNotFoundException;
import by.bsuir.mpp.computershop.controller.exception.dto.CustomFieldErrorResponse;
import by.bsuir.mpp.computershop.controller.exception.dto.ErrorResponse;
import by.bsuir.mpp.computershop.controller.exception.dto.TimestampErrorResponse;
import by.bsuir.mpp.computershop.controller.exception.dto.ValidationErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@ControllerAdvice
public class GlobalRestExceptionHandler {
    @Order(1000)
    @ExceptionHandler(value = ControllerException.class)
    protected ResponseEntity<ErrorResponse> handleControllerException(ControllerException ex) {
        ErrorResponse responseBody = new TimestampErrorResponse("Operation failed");
        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Order(0)
    @ExceptionHandler(value = AccessDeniedException.class)
    protected ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex) {
        ErrorResponse responseBody = new TimestampErrorResponse("Access denied");
        return new ResponseEntity<>(responseBody, HttpStatus.FORBIDDEN);
    }

    @Order(10)
    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        ErrorResponse responseBody = new TimestampErrorResponse("Requested resource not found");
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    @Order(15)
    @ExceptionHandler(value = {InvalidDataException.class, HttpMessageNotReadableException.class})
    protected ResponseEntity<ErrorResponse> handleInvalidData(Exception ex) {
        ErrorResponse responseBody = new TimestampErrorResponse("Invalid data provided");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @Order(20)
    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse responseBody = new TimestampErrorResponse(ex.getMessage());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @Order(20)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        ErrorResponse responseBody = new TimestampErrorResponse("Invalid type for " + ex.getName() + " argument");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @Order(30)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorResponse> handleInvalidArguments(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        ValidationErrorResponse responseBody = processFieldErrors(errors);
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    private ValidationErrorResponse processFieldErrors(List<FieldError> errors) {
        ValidationErrorResponse result = new ValidationErrorResponse("Invalid arguments");
        for (FieldError fieldError : errors) {
            result.addFieldError(new CustomFieldErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return result;
    }
}
