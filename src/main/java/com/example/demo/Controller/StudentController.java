package com.example.demo.Controller;

import com.example.demo.Model.StudentModels;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("addStudent/")
    public StudentModels addStudent(@RequestBody StudentModels studentModel){
        return studentRepository.save(studentModel);
    }

}
