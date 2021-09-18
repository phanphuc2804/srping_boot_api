package com.example.spring_boot_api.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId ;

    @Column(name= "first_name")
    
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;
}
