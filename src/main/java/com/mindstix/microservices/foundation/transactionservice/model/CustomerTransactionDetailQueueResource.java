package com.mindstix.microservices.foundation.transactionservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CustomerTransactionDetailQueueResource {
    private Long accountNumber;
    private String transactionType;
    private BigDecimal amount;
}
