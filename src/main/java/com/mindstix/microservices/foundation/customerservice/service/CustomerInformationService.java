package com.mindstix.microservices.foundation.customerservice.service;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.mindstix.microservices.foundation.customerservice.model.CustomerInformationModel;

import java.util.Optional;

public interface CustomerInformationService {

    Optional<Long> createNewCustomer(CustomerInformationModel customerInformation);
    Optional<CustomerAccountInformationModel> getCustomerDetails(String emailId);
    static CustomerInformation toCustomerInformation(CustomerInformationModel customerInfo){
        return CustomerInformation
                .builder()
                .customerName(customerInfo.getCustomerName())
                .email(customerInfo.getEmail())
                .contact(customerInfo.getContact())
                .build();
    }

     static CustomerAccountInformationModel toCustomerDetail(CustomerInformation customerInformation) {
        CustomerAccountInformationModel customerDetail = new CustomerAccountInformationModel();
        customerDetail.setCustomerName(customerInformation.getCustomerName());
        customerDetail.setEmail(customerInformation.getEmail());
        customerDetail.setAccountNumber(customerInformation.getCustomerAccountDetails().getAccountNumber());
        customerDetail.setAccountBalance(customerInformation.getCustomerAccountDetails().getAccountBalance());
        return customerDetail;
    }
}
