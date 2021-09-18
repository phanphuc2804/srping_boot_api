package com.example.spring_boot_api;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }
    //Save
    private void insertEmployees(EmployeeRepository repository){
        Employee employee = Employee.builder()
                .firstName("Phan")
                .lastName("Hoang Phuc")
                .email("phucphan@gmail.com")
                .build();
        repository.save(employee);

    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            insertEmployees(repository);
            System.out.println(repository.findAll());
        };
    }
}
