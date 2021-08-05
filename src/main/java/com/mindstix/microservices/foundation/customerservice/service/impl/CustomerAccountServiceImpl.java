package com.mindstix.microservices.foundation.customerservice.service.impl;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.customerservice.dao.CustomerAccountDetailsDao;
import com.mindstix.microservices.foundation.customerservice.service.CustomerAccountService;
import com.mindstix.microservices.foundation.customerservice.utlities.ConvertToObjectUtility;
import org.springframework.stereotype.Service;


@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {
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


}
