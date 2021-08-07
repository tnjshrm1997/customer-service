package com.microservices.foundation.customerservice.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Email;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerInformation {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(updatable = false)
        private Integer pkCustomerId;
        @Column(nullable = false)
        private String customerName;
        @Email
        @Column(unique = true,nullable = false)
        private String email;
        @Column(unique = true,nullable = false)
        private String contact;
        @CreationTimestamp
        private Timestamp createTime;
        @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "fkCustomerInformationId")
        private CustomerAccountDetails customerAccountDetails;

}
