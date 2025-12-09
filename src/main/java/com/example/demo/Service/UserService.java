package com.example.demo.Service;

import com.example.demo.Dto.ChangePasswordDTO;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.Dto.RegisterDTO;
import com.example.demo.Model.UserModel;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

public interface UserService {


    ResponseEntity<?> register(RegisterDTO registerDTO);

    ResponseEntity<?> login(LoginDTO loginDTO);

//    ResponseEntity<?> passwordReSet(ChangePasswordDTO changePasswordDTO);

    ResponseEntity<?> passwordReSet2(ChangePasswordDTO changePasswordDTO, String email);

//    UserModel register(RegisterDTO registerDTO);
//    String login()
}
