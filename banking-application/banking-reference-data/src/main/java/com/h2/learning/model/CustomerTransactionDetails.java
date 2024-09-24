package com.h2.learning.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CustomerTransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID", nullable = false)
    @NotNull
    private CustomerList customer;
    
    private String date;
    private int deposit;
    private int withdraw;
    private int closingBalance;
}
