package com.mindstix.microservices.foundation.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerServiceExceptionHandler {

    private static final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    @ExceptionHandler(value={CustomerServiceExceptions.class})
    public ResponseEntity<Object> handleCustomerServiceException(CustomerServiceExceptions e){
        CustomerExceptionMessage exception =  new CustomerExceptionMessage(e.getMessage(), badRequest);
        return new ResponseEntity<>(exception,badRequest);
    }
}
