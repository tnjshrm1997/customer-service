package com.microservices.foundation.customerservice.service;

import com.microservices.foundation.customerservice.entity.CustomerInformation;
import com.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;

import java.math.BigDecimal;
import java.util.List;


public interface CustomerAccountService {

    Long saveCustomerAccount(CustomerInformation customerInformation);
    void updateCustomerAccount(CustomerTransactionDetailQueueResource accountTransactions);
    List<CustomerAccountInformationModel> getCustomerGreaterAmount(BigDecimal amount);
    List<CustomerAccountInformationModel> getCustomerLessAmount(BigDecimal amount);

}
