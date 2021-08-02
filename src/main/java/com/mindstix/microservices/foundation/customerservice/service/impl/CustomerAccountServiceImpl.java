package com.mindstix.microservices.foundation.customerservice.service.impl;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.customerservice.repositories.CustomerAccountDetailsRepository;
import com.mindstix.microservices.foundation.customerservice.service.CustomerAccountService;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

    final CustomerAccountDetailsRepository customerAccountDetailsRepository;

    public CustomerAccountServiceImpl(CustomerAccountDetailsRepository customerAccountDetailsRepository) {
        this.customerAccountDetailsRepository = customerAccountDetailsRepository;
    }

    @Override
    public Long saveCustomerAccount(CustomerInformation customerInformation) {
        CustomerAccountDetails accountDetails = CustomerAccountService.toCustomerAccountDetails(customerInformation);
        customerAccountDetailsRepository.save(accountDetails);
        return accountDetails.getAccountNumber();
    }
}
