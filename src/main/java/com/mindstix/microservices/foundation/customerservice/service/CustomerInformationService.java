package com.mindstix.microservices.foundation.customerservice.service;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.customerservice.model.CustomerInformationModel;

import java.util.Optional;

public interface CustomerInformationService {

    Optional<Long> createNewCustomer(CustomerInformationModel customerInformation);

    static CustomerInformation toCustomerInformation(CustomerInformationModel customerInfo){
        return CustomerInformation
                .builder()
                .customerName(customerInfo.getCustomerName())
                .email(customerInfo.getEmail())
                .contact(customerInfo.getContact())
                .build();
    }

}
