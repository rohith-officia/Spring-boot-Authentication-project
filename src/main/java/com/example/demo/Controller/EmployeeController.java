package com.example.demo.Controller;

import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("getEmployee/")
    public ResponseEntity<ResponseDTO<Map<String , Object>>> getEmployee(@RequestBody RequestDTO requestDTO){
        return employeeService.getEmployee(requestDTO);
    }
}
