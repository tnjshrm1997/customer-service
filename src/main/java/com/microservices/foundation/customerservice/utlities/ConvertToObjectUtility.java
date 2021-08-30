package com.microservices.foundation.customerservice.utlities;

import com.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import com.microservices.foundation.customerservice.entity.CustomerInformation;
import com.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.microservices.foundation.customerservice.model.CustomerInformationModel;

import java.math.BigDecimal;

 public class ConvertToObjectUtility {
    private ConvertToObjectUtility(){
       throw new IllegalStateException("Utility class");
    }
    public static CustomerAccountDetails toCustomerAccountDetails(CustomerInformation customerInformation){
        return CustomerAccountDetails
                .builder()
                .fkCustomerInformationId(customerInformation)
                .accountNumber(System.currentTimeMillis())
                .accountBalance(BigDecimal.ZERO)
                .build();
    }
    public static CustomerInformation toCustomerInformation(CustomerInformationModel customerInfo){
        return CustomerInformation
                .builder()
                .customerName(customerInfo.getCustomerName())
                .email(customerInfo.getEmail())
                .contact(customerInfo.getContact())
                .build();
    }

    public static CustomerAccountInformationModel toCustomerDetail(CustomerInformation customerInformation) {
        return CustomerAccountInformationModel
                .builder()
                .customerName(customerInformation.getCustomerName())
                .email(customerInformation.getEmail())
                .accountNumber(customerInformation.getCustomerAccountDetails().getAccountNumber())
                .accountBalance(customerInformation.getCustomerAccountDetails().getAccountBalance())
                .build();
    }

     public static CustomerAccountInformationModel toCustomerAccountObject(CustomerAccountDetails customerAccountDetails) {
         return CustomerAccountInformationModel
                 .builder()
                 .customerName(customerAccountDetails.getFkCustomerInformationId().getCustomerName())
                 .email(customerAccountDetails.getFkCustomerInformationId().getEmail())
                 .accountNumber(customerAccountDetails.getAccountNumber())
                 .accountBalance(customerAccountDetails.getAccountBalance())
                 .build();
     }
 }
