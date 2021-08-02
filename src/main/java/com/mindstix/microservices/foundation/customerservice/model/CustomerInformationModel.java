package com.mindstix.microservices.foundation.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInformationModel {
    private Integer pkCustomerId;
    private String customerName;
    private String email;
    private String contact;
}