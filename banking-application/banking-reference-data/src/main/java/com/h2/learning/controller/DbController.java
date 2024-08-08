package com.h2.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DbController {
    
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Spring-Boot H2 Database Session";
    }
    
}
