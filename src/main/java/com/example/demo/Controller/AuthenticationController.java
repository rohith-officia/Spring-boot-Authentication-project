package com.example.demo.Controller;

import com.example.demo.Dto.ChangePasswordDTO;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.Dto.RegisterDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("Register/")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
        return userService.register(registerDTO);
    }

    @PostMapping("Login/")
        public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }

//    @PutMapping("PasswordReSet/{email}")
//    public ResponseEntity<?> passwordReSet(@PathVariable String email , @RequestBody UserModel userModel){
//
//        Optional<UserModel> userOpt = userRepository.findById(email);
//
//        // Check if user exists
//        if(userOpt.isEmpty()){
//            return ResponseEntity.status(404).body(Map.of(
//                    "status", "Failed",
//                    "message", "User not found"
//            ));
//        }
//
//        // Update Password
//        UserModel user = userOpt.get();
//        user.setPassword(userModel.getPassword());
//        userRepository.save(user);   // ← IMPORTANT: Save changes
//
//        return ResponseEntity.ok(Map.of(
//                "status", "Successful",
//                "message", "Password has been reset"
//        ));
//    }

    @PutMapping("/PasswordReSet2/{email}/")
    public ResponseEntity<?> passwordReSet2(@RequestBody ChangePasswordDTO changePasswordDTO , @PathVariable String email){
        return (userService.passwordReSet2(changePasswordDTO , email));
    }


}
