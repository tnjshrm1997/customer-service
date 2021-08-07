package com.microservices.foundation.customerservice.service.impl;

import com.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import com.microservices.foundation.customerservice.entity.CustomerInformation;
import com.microservices.foundation.customerservice.utlities.ConvertToObjectUtility;
import com.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;
import com.microservices.foundation.customerservice.dao.CustomerAccountDetailsDao;
import com.microservices.foundation.customerservice.service.CustomerAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAccountServiceImpl.class);
    final CustomerAccountDetailsDao customerAccountDetailsDao;
    public CustomerAccountServiceImpl(CustomerAccountDetailsDao customerAccountDetailsDao) {
        this.customerAccountDetailsDao = customerAccountDetailsDao;
    }

    @Override
    public Long saveCustomerAccount(CustomerInformation customerInformation) {
        CustomerAccountDetails accountDetails = ConvertToObjectUtility.toCustomerAccountDetails(customerInformation);
        customerAccountDetailsDao.save(accountDetails);
        return accountDetails.getAccountNumber();
    }
    public void updateCustomerAccount(CustomerTransactionDetailQueueResource accountTransactions) {
        Optional<CustomerAccountDetails> accountDetails =  Optional.ofNullable(customerAccountDetailsDao.findByAccountNumber(accountTransactions.getAccountNumber()));
        if (accountDetails.isPresent()){
            LOGGER.info("Updating records for account: {}",accountDetails.get().getAccountNumber());
            BigDecimal accountBalance = accountDetails.get().getAccountBalance();
            BigDecimal transactionsAmount = accountTransactions.getAmount();
            if(transactionsAmount.doubleValue() > accountBalance.doubleValue() && accountTransactions.getTransactionType().equalsIgnoreCase("debit")) {
                LOGGER.info("Insufficient account balance.. Not processing payment");
                return;
            }
            accountDetails.get().setAccountBalance(accountTransactions.getTransactionType().equalsIgnoreCase("credit")
                    ?(accountBalance.add(accountTransactions.getAmount())):(accountBalance.subtract(accountTransactions.getAmount())));
            customerAccountDetailsDao.save(accountDetails.get());
        }
    }


}
