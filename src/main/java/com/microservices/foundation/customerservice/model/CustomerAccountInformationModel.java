package com.microservices.foundation.customerservice.model;


import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAccountInformationModel {
    private String customerName;
    private String email;
    private Long accountNumber;
    private BigDecimal accountBalance;
}
