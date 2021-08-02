package com.mindstix.microservices.foundation.customerservice.service.impl;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import com.mindstix.microservices.foundation.customerservice.model.CustomerInformationModel;
import com.mindstix.microservices.foundation.customerservice.repositories.CustomerInformationRepository;
import com.mindstix.microservices.foundation.customerservice.service.CustomerAccountService;
import com.mindstix.microservices.foundation.customerservice.service.CustomerInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerInformationServiceImpl implements CustomerInformationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInformationServiceImpl.class);
    final CustomerInformationRepository customerInformationRepository;
    final CustomerAccountService customerAccountService;
    public CustomerInformationServiceImpl(CustomerInformationRepository customerInformationRepository, CustomerAccountService customerAccountService) {
        this.customerInformationRepository = customerInformationRepository;
        this.customerAccountService = customerAccountService;
    }

    @Override
    public Optional<Long> createNewCustomer(CustomerInformationModel customerInformationModel) {

        Long accountNumber = null;
        try{
            if(customerInformationRepository.findByEmail(customerInformationModel.getEmail())!=null){
                LOGGER.debug("User is already exists in system");
                return Optional.empty();
            }
            CustomerInformation customerInfo = CustomerInformationService.toCustomerInformation(customerInformationModel);
            customerInformationRepository.save(customerInfo);
            accountNumber = customerAccountService.saveCustomerAccount(customerInfo);
            LOGGER.info("User is created with account number: {}",accountNumber);
            return Optional.ofNullable(accountNumber);
        }catch (Exception e){
            LOGGER.error("Exception occurred while inserting customer: {}",e.getMessage());
        }
        return Optional.ofNullable(accountNumber);
    }

}
