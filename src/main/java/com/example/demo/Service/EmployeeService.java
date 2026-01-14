package com.example.demo.Service;

import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmployeeService {
    ResponseEntity<ResponseDTO<Map<String, Object>>> getEmployee(RequestDTO requestDTO);
}
