package com.example.demo.Controller;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AdminController {

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    AdminService adminService;

    @GetMapping("getAllUser/")
    public ResponseEntity<?> getAllUser(){
        return adminService.getAllUser();
    }
}
