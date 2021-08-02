package com.mindstix.microservices.foundation.customerservice.entity;


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
        @Column(columnDefinition = "varchar", nullable = false)
        private String customerName;
        @Email
        @Column(columnDefinition = "varchar",unique = true,nullable = false)
        private String email;
        @Column(length = 10, columnDefinition = "varchar",unique = true,nullable = false)
        private String contact;
        @CreationTimestamp
        @Column(columnDefinition = "date")
        private Timestamp createTime;
        @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "fkCustomerInformationId")
        private CustomerAccountDetails customerAccountDetails;

}
