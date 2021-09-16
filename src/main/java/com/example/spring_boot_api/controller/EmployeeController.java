package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


}
