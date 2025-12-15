package com.example.demo.Service;

import com.example.demo.Dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface AdminService {

    public ResponseEntity<ResponseDTO<List<Map<String , Object>>>> getAllUser();

    ResponseEntity<ResponseDTO<Map<String , Object>>> getUser(String email);
}
