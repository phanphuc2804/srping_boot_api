package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.entity.EmployeeDTO;
import com.example.spring_boot_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees(){
//        return employeeService.getAllEmployees();
//    }
//    @GetMapping("/employees/{id}")
//    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
//        return employeeService.getEmployeeById(employeeId);
//    }
    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployeeList() {
        List<Employee> employees= employeeService.getAllEmployees();

        List<EmployeeDTO> dtoList= new ArrayList<>();
        for (Employee employee : employees) {
            dtoList.add(new EmployeeDTO(employee));
        }
        return dtoList;
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId,@RequestBody Employee employee){
        return  employeeService.updateEmployeeById(employeeId,employee);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return "Delete Sucessfully!";
    }

    @GetMapping("/")
    public String helloWorld(){
        return "Phan Hoang Phuc xin chao!";
    }
}
