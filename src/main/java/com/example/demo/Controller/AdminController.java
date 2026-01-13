package com.example.demo.Controller;

import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("getAllUser/")
    public ResponseEntity<ResponseDTO<List<Map<String , Object>>>> getAllUser() {
        return adminService.getAllUser();
    }

    @GetMapping("getALlUserDao/")
    public ResponseEntity<ResponseDTO<List<Map<String , Object>>>> getAllUserDao(){
        return adminService.getAllUserDao();
    }

    @PostMapping("getUser/")
    public ResponseEntity<ResponseDTO<Map<String , Object>>> getUser(@RequestBody Map<String , String > body){
        return adminService.getUser(body.get("email"));
    }

    @PostMapping("addUser/")
    public ResponseEntity<ResponseDTO<Map<String , Object>>> addUser(@RequestBody Map<String , String> body){
        return adminService.addUser(body);
    }

    @PostMapping("addNewUser/")
    public ResponseEntity<ResponseDTO<Map<String , Object>>> addNewUser(@RequestBody RequestDTO requestDTO){
        return adminService.addNewUser(requestDTO);
    }
}
