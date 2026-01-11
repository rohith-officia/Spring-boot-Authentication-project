package com.example.demo.Controller;

import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Model.StudentModel;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("addStudent/")
    public StudentModel addStudent(@RequestBody StudentModel studentModel){
        return studentRepository.save(studentModel);
    }

}
