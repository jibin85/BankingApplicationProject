package com.h2.learning.controller;

import com.h2.learning.model.CustomerList;
import com.h2.learning.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class DbController {
    
    @Autowired
    private CustomerRepository repository;
    
    @GetMapping
    public List<CustomerList> getAllCustomers(){
//        return repository.findAll();
        return null;
    }
    
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Spring-Boot H2 Database Session";
    }
    
}
