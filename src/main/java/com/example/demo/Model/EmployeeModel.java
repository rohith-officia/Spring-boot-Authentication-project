package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    @OneToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private UserModel user;
}
