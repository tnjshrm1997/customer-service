package com.mindstix.microservices.foundation.customerservice.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.Email;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        @Column(length = 255, columnDefinition = "varchar", nullable = false)
        private String customerName;
        @Email
        @Column(length = 255, columnDefinition = "varchar",unique = true,nullable = false)
        private String email;
        @Column(length = 10, columnDefinition = "varchar",unique = true,nullable = false)
        private String contact;
        @CreationTimestamp
        private Timestamp createTime;
        @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "fkCustomerInformationId")
        private CustomerAccountDetails customerAccountDetails;

}
