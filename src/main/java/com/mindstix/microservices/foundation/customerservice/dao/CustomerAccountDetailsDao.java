package com.mindstix.microservices.foundation.customerservice.dao;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountDetailsDao extends JpaRepository<CustomerAccountDetails, Integer> {

    CustomerAccountDetails findByAccountNumber(Long accountNumber);
}
