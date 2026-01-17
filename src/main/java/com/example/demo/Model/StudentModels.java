package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
//import lombok.Data;

@Entity
@Data
@Table(name = "StudentDetail")
//@Data
public class StudentModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RollNo;
    private String name;
    private int Standard;

//    public void setName(String name){
//        this.name = name;
//    }
}
