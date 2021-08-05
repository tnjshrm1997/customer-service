package com.mindstix.microservices.foundation.customerservice.service;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;


public interface CustomerAccountService {

    Long saveCustomerAccount(CustomerInformation customerInformation);

}
