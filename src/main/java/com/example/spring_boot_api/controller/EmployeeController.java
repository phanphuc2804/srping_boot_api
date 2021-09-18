package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.service.EmployeeService;
import com.example.spring_boot_api.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public ResponseEntity<Employee>  saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public List<Employee> getAlEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId,@Valid @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(employeeId,employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
        return "Delete Successfully";
    }
}
