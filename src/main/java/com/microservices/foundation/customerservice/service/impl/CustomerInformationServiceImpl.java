package com.microservices.foundation.customerservice.service.impl;

import com.microservices.foundation.customerservice.entity.CustomerInformation;
import com.microservices.foundation.customerservice.model.CustomerAccountInformationModel;
import com.microservices.foundation.customerservice.model.CustomerInformationModel;
import com.microservices.foundation.customerservice.service.CustomerAccountService;
import com.microservices.foundation.customerservice.service.CustomerInformationService;
import com.microservices.foundation.customerservice.utlities.ConvertToObjectUtility;
import com.microservices.foundation.customerservice.dao.CustomerInformationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerInformationServiceImpl implements CustomerInformationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInformationServiceImpl.class);
    final CustomerInformationDao customerInformationDao;
    final CustomerAccountService customerAccountService;
    public CustomerInformationServiceImpl(CustomerInformationDao customerInformationDao, CustomerAccountService customerAccountService) {
        this.customerInformationDao = customerInformationDao;
        this.customerAccountService = customerAccountService;
    }

    @Override
    public Optional<Long> createNewCustomer(CustomerInformationModel customerInformationModel) {

        Long accountNumber = null;
        try{
            if(getCustomerByEmailId(customerInformationModel.getEmail())!=null){
                LOGGER.debug("User is already exists in system");
                return Optional.empty();
            }
            CustomerInformation customerInfo = ConvertToObjectUtility.toCustomerInformation(customerInformationModel);
            customerInformationDao.save(customerInfo);
            accountNumber = customerAccountService.saveCustomerAccount(customerInfo);
            LOGGER.info("User is created with account number: {}",accountNumber);
            return Optional.ofNullable(accountNumber);
        }catch (Exception e){
            LOGGER.error("Exception occurred while inserting customer: {}",e.getMessage());
        }
        return Optional.ofNullable(accountNumber);
    }

    @Override
    public Optional<CustomerAccountInformationModel> getCustomerDetails(String emailId) {
        Optional<CustomerInformation> customerInfo = Optional.ofNullable(getCustomerByEmailId(emailId));
        CustomerAccountInformationModel accountInformation= null;
        if(customerInfo.isPresent()){
            LOGGER.info("Customer found with given email: {}",emailId);
            accountInformation = ConvertToObjectUtility.toCustomerDetail(customerInfo.get());
        }
        return Optional.ofNullable(accountInformation);
    }

    @Override
    public Long getCustomerAccountNumber(String emailId) {
        Optional<CustomerInformation> customerInformation = Optional.ofNullable(getCustomerByEmailId(emailId));
        Long accountNumber = null;
        if(customerInformation.isPresent()){
            LOGGER.info("User found in system");
            accountNumber =  customerInformation.get().getCustomerAccountDetails().getAccountNumber();
        }
        return accountNumber;
    }

    @Override
    public CustomerInformation getCustomerByEmailId(String emailId) {
        return customerInformationDao.findByEmail(emailId);
    }

}
