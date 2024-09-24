package com.h2.learning.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class CustomerList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;

    @NotNull
    private String customerName;

    @Column(unique = true, nullable = false)
    @NotNull
    private String customerID;
}
