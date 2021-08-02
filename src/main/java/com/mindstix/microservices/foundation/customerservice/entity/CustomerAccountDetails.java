package com.mindstix.microservices.foundation.customerservice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CustomerAccountDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(updatable = false)
        private Integer pkCustomerAccountId;
        @OneToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name="fk_customer_information_id",referencedColumnName = "pkCustomerId")
        private CustomerInformation fkCustomerInformationId;
        @Column(unique = true, updatable = false, nullable = false)
        private Long accountNumber;
        @NotNull
        private BigDecimal accountBalance;
        @CreationTimestamp
        private Timestamp createTime;
        @UpdateTimestamp
        private LocalDateTime updateTime;
}
