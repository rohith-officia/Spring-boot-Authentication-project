package com.example.demo.Service;

import org.springframework.http.ResponseEntity;

public interface AdminService {

    public ResponseEntity<?> getAllUser();

    public ResponseEntity<?> getUser(String email);
}
