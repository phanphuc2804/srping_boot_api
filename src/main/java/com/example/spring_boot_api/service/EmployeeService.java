package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long employeeId);

    public void deleteById(Long employeeId);

    public Employee updateEmployeeById(Long employeeId, Employee employee);
}
