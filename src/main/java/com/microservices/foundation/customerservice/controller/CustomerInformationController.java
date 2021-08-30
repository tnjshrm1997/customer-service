package com.microservices.foundation.customerservice.controller;

import com.microservices.foundation.customerservice.exception.CustomerServiceExceptions;
import com.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.microservices.foundation.customerservice.model.CustomerInformationModel;
import com.microservices.foundation.customerservice.service.CustomerInformationService;
import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/customer-service/customer/")
@RestController
public class CustomerInformationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInformationController.class);
    final CustomerInformationService customerInformationService;
    final Environment environment;
    public CustomerInformationController(CustomerInformationService customerInformationService, Environment environment) {
        this.customerInformationService = customerInformationService;
        this.environment = environment;
    }
    @PostMapping()
    @Retryable(value = {CustomerServiceExceptions.class, JDBCConnectionException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public ResponseEntity<String> createCustomer(@RequestBody CustomerInformationModel customerInformation){
        LOGGER.info(environment.getProperty("local.server.port"));
        Optional<Long> accountNumber = customerInformationService.createNewCustomer(customerInformation);
        if(accountNumber.isPresent()){
            String message = "Customer account is created with accountId: "+ accountNumber.get();
            return ResponseEntity.of(Optional.of(message));
        }
        throw new CustomerServiceExceptions("Email Id is already Exists");
    }
    @GetMapping("{emailId}")
    @Retryable(value = {JDBCConnectionException.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public ResponseEntity<CustomerAccountInformationModel> getCustomerDetails(@PathVariable String emailId){
        Optional<CustomerAccountInformationModel> customerResource = customerInformationService.getCustomerDetails(emailId);
        if(customerResource.isPresent()){
            return ResponseEntity.of(customerResource);
        }
        return ResponseEntity.notFound().build();
    }
}
