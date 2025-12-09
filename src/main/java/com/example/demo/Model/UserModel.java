package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "UserDetail")
public class UserModel {



    @Id
    @Column(name = "email" , unique = true , nullable = false)
    private String email;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String username;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
