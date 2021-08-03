package com.mindstix.microservices.foundation.customerservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerExceptionMessage {
    private final String message;
    private final HttpStatus httpStatus;
}
