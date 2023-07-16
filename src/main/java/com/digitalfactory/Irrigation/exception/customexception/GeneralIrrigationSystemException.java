package com.digitalfactory.Irrigation.exception.customexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class GeneralIrrigationSystemException extends RuntimeException{

    private String message;
    private HttpStatus statusCode;

}
