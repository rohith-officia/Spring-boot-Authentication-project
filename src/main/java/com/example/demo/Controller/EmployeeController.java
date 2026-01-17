package com.example.demo.Controller;

import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Dto.ResponseHeadDTO;
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
        if(requestDTO.getEmail() == null){
            System.out.print(requestDTO.getEmail());
            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO("Unsuccessfull" , 400 , "User not found.....");
            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO , null);
            return ResponseEntity.ok(responseDTO);
        }
        return employeeService.getEmployee(requestDTO);
    }

}
