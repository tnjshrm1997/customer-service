package com.mindstix.microservices.foundation.customerservice.service;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;


public interface CustomerAccountService {

    Long saveCustomerAccount(CustomerInformation customerInformation);

    void updateCustomerAccount(CustomerTransactionDetailQueueResource accountTransactions);
}
