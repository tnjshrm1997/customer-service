package com.mindstix.microservices.foundation.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerServiceExceptionHandler {

    private static final HttpStatus HTTP_BADREQUEST = HttpStatus.BAD_REQUEST;
    @ExceptionHandler(value={CustomerServiceExceptions.class})
    public ResponseEntity<Object> handleCustomerServiceException(CustomerServiceExceptions e){
        CustomerExceptionMessage exception =  toExceptionMessageObject(e.getMessage(), HTTP_BADREQUEST);
        return new ResponseEntity<>(exception,HTTP_BADREQUEST);
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> validationErrors(BindException exception){
        CustomerExceptionMessage transactionException= toExceptionMessageObject(exception.getAllErrors().toString(), HTTP_BADREQUEST);
        return new ResponseEntity<>(transactionException,HTTP_BADREQUEST);
    }
    public static CustomerExceptionMessage toExceptionMessageObject(String message, HttpStatus status){
        return CustomerExceptionMessage
                .builder()
                .message(message)
                .httpStatus(status)
                .build();
    }
}
