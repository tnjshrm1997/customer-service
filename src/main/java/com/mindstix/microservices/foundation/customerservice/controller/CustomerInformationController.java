package com.mindstix.microservices.foundation.customerservice.controller;


import com.mindstix.microservices.foundation.customerservice.exception.CustomerServiceExceptions;
import com.mindstix.microservices.foundation.customerservice.model.CustomerInformationModel;
import com.mindstix.microservices.foundation.customerservice.service.CustomerInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/customer-service/")
@RestController
public class CustomerInformationController {

    final CustomerInformationService customerInformationService;

    public CustomerInformationController(CustomerInformationService customerInformationService) {
        this.customerInformationService = customerInformationService;
    }
    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerInformationModel customerInformation){
        Optional<Long> accountNumber = customerInformationService.createNewCustomer(customerInformation);
        if(accountNumber.isPresent()){
            String message = "Customer account is created with accountId: "+ accountNumber.get();
            return ResponseEntity.of(Optional.of(message));
        }
        throw new CustomerServiceExceptions("Email Id is already Exists");
    }
}
