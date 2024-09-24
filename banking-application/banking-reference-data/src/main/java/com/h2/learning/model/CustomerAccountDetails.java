package com.h2.learning.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class CustomerAccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID", nullable = false)
    @NotNull
    private CustomerList customer;

    @NotNull
    private int customerAge;

    @NotNull
    private int accountType;

    @NotNull
    private int accountNumber;

    @NotNull
    private int ifsc;
}
