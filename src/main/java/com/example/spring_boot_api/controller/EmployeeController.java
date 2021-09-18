package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        LOGGER.info("Inside saveEmployee");
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        LOGGER.info("Inside getAllEmployee");
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
        LOGGER.info("Inside getEmployeeById");
        return employeeService.getEmployeeById(employeeId);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId,@RequestBody Employee employee){
        LOGGER.info("Inside updateEmployee");
        return  employeeService.updateEmployeeById(employeeId,employee);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable("id") Long employeeId){
        LOGGER.info("Inside deleteEmployee");
        employeeService.deleteById(employeeId);
        return "Delete Sucessfully!";
    }

    @GetMapping("/")
    public String helloWorld(){
        LOGGER.info("Inside helloWorld");
        return "Phan Hoang Phuc xin chao!";
    }
}
