package com.digitalfactory.Irrigation.exception.customexception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends GeneralIrrigationSystemException{
    public EntityNotFoundException(String message) {

        super(message, HttpStatus.BAD_REQUEST);
    }
}
