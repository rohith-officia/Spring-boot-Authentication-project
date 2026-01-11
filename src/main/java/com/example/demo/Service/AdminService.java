package com.example.demo.Service;

import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AdminService {

    ResponseEntity<ResponseDTO<List<Map<String , Object>>>> getAllUser();

    ResponseEntity<ResponseDTO<Map<String , Object>>> getUser(String email);

    ResponseEntity<ResponseDTO<Map<String , Object>>> addUser(Map<String, String> body);

    ResponseEntity<ResponseDTO<Map<String, Object>>> addNewUser(RequestDTO requestDTO);
}
