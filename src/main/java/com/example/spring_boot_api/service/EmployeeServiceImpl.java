package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public void deleteById(Long employeeId) {

    }

    @Override
    public Employee updateEmployeeById(Long employeeId, Employee employee) {
        return null;
    }
}
