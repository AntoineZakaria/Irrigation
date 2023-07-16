package com.digitalfactory.Irrigation.exception.handler;


import com.digitalfactory.Irrigation.exception.customexception.GeneralIrrigationSystemException;
import com.digitalfactory.Irrigation.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class IrrigationSystemHandler {

    @ExceptionHandler(GeneralIrrigationSystemException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            GeneralIrrigationSystemException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, errors.toString());
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

}
