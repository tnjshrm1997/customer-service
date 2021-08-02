package com.mindstix.microservices.foundation.customerservice.repositories;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInformationRepository extends JpaRepository<CustomerInformation, Integer> {

    CustomerInformation findByEmail(String emailId);
}
