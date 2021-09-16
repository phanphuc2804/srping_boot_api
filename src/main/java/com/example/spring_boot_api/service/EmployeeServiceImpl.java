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
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee employeeDB= employeeRepository.findById(id).get();

        if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())){
            employeeDB.setFirstName(employee.getFirstName());
        }

        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())){
            employeeDB.setLastName(employee.getLastName());
        }

        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            employeeDB.setEmail(employee.getEmail());
        }
        return employeeRepository.save(employeeDB);
    }
}
