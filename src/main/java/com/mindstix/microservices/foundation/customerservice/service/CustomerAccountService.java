package com.mindstix.microservices.foundation.customerservice.service;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;

import java.math.BigDecimal;

public interface CustomerAccountService {

    Long saveCustomerAccount(CustomerInformation customerInformation);
    static CustomerAccountDetails toCustomerAccountDetails(CustomerInformation customerInformation){
        return CustomerAccountDetails
                .builder()
                .fkCustomerInformationId(customerInformation)
                .accountNumber(System.currentTimeMillis())
                .accountBalance(BigDecimal.ZERO)
                .build();
    }

}
