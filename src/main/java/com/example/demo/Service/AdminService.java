package com.example.demo.Service;

import org.springframework.http.ResponseEntity;

public interface AdminService {

    public ResponseEntity<?> getAllUser();

    ResponseEntity<?> getUser(String email);
}
