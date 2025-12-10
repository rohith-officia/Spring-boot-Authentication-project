package com.example.demo.Dto;

public class ResponseDTO {
    private final String email;
    private final String username;

    public ResponseDTO(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() { return email; }
    public String getUsername() { return username; }
}
