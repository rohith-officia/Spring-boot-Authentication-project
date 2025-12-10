package com.example.demo.Controller;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("getUser/")
    public ResponseEntity<?> getUser(@RequestBody Map<String , String > body){
        return adminService.getUser(body.get("email"));
    }
}
