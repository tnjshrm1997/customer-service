package com.mindstix.microservices.foundation.customerservice.model;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAccountInformationModel {
    private String customerName;
    private String email;
    private Long accountNumber;
    private double accountBalance;
}
