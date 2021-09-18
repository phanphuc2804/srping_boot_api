package com.example.spring_boot_api.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDTO(Employee original) {
        this.firstName= original.getFirstName();
        this.lastName= original.getLastName();
        this.email= original.getEmail();
    }
}
