package com.microservices.foundation.customerservice.exception;


public class CustomerServiceExceptions extends RuntimeException{
    public CustomerServiceExceptions(String message) {
        super(message);
    }
    public CustomerServiceExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
