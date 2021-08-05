package com.mindstix.microservices.foundation.customerservice.service;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.mindstix.microservices.foundation.customerservice.model.CustomerInformationModel;

import java.util.Optional;

public interface CustomerInformationService {

    Optional<Long> createNewCustomer(CustomerInformationModel customerInformation);
    Optional<CustomerAccountInformationModel> getCustomerDetails(String emailId);
    CustomerInformation getCustomerByEmailId(String emailId);
    Long getCustomerAccountNumber(String emailId);

}
