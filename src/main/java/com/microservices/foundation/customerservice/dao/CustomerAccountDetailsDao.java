package com.microservices.foundation.customerservice.dao;

import com.microservices.foundation.customerservice.entity.CustomerAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CustomerAccountDetailsDao extends JpaRepository<CustomerAccountDetails, Integer> {
    CustomerAccountDetails findByAccountNumber(Long accountNumber);
    List<CustomerAccountDetails> findByAccountBalanceGreaterThan(BigDecimal amount);
}
