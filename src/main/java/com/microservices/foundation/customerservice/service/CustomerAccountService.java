package com.microservices.foundation.customerservice.service;

import com.microservices.foundation.customerservice.entity.CustomerInformation;
import com.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;


public interface CustomerAccountService {

    Long saveCustomerAccount(CustomerInformation customerInformation);

    void updateCustomerAccount(CustomerTransactionDetailQueueResource accountTransactions);
}
