package com.mindstix.microservices.foundation.customerservice.repositories;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAccountDetailsRepository extends JpaRepository<CustomerAccountDetails, Integer> {

    CustomerAccountDetails findByAccountNumber(Long accountNumber);
}
