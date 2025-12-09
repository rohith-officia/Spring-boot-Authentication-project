package com.example.demo.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegisterDTO {

    private String username;
    private String email;
    private String password;

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }
}
