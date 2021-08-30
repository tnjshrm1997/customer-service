package com.microservices.foundation.customerservice.controller;


import com.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.microservices.foundation.customerservice.service.CustomerAccountService;
import com.microservices.foundation.customerservice.service.CustomerInformationService;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customer-service/account/")
public class CustomerAccountController {

    final CustomerAccountService customerAccountService;
    final CustomerInformationService customerInformationService;
    public CustomerAccountController(CustomerAccountService customerAccountService, CustomerInformationService customerInformationService) {
        this.customerAccountService = customerAccountService;
        this.customerInformationService = customerInformationService;
    }
    @GetMapping("{emailId}")
    @Retryable(value = {JDBCConnectionException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public Long getCustomerAccountNumber (@PathVariable String emailId){
        return customerInformationService.getCustomerAccountNumber(emailId);
    }
    @GetMapping("amount/{amount}")
    @Retryable(value = {JDBCConnectionException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public List<CustomerAccountInformationModel> getCustomerAccountNumber (@PathVariable BigDecimal amount){
        return customerAccountService.getCustomerGreaterAmount(amount);
    }
}
