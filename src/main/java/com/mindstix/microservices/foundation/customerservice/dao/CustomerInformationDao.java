package com.mindstix.microservices.foundation.customerservice.dao;

import com.mindstix.microservices.foundation.customerservice.entity.CustomerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInformationDao extends JpaRepository<CustomerInformation, Integer> {

    CustomerInformation findByEmail(String emailId);
}
