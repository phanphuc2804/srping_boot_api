package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(Long employeeId, Employee employee) {
        Employee employeedb= employeeRepository.findById(employeeId).get();
        if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())){
            employeedb.setFirstName(employee.getFirstName());
        }

        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())){
            employeedb.setLastName(employee.getLastName());
        }

        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            employeedb.setEmail(employee.getEmail());
        }
        return employeeRepository.save(employeedb);
    }
}
