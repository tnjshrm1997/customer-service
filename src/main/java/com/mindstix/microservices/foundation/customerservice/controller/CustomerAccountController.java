package com.mindstix.microservices.foundation.customerservice.controller;


import com.mindstix.microservices.foundation.customerservice.service.CustomerAccountService;
import com.mindstix.microservices.foundation.customerservice.service.CustomerInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Long getCustomerAccountNumber (@PathVariable String emailId){
        return customerInformationService.getCustomerAccountNumber(emailId);
    }
}
