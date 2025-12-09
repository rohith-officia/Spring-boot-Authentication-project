package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.ChangePasswordDTO;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.Dto.RegisterDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> register(RegisterDTO registerDTO) {
        UserModel user = new UserModel();

        if(userRepository.findById(registerDTO.getEmail()).isPresent()){
            return ResponseEntity.status(409).body(Map.of(
                    "status" , "Unsuccessful",
                    "Message" , "User already exist"
            ));
        }
        user.setEmail(registerDTO.getEmail());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(Map.of(
                "status" , "success",
                "data" , user
        ));
    }

    @Override
    public ResponseEntity<?> login(LoginDTO loginDTO) {
        Optional<UserModel> userOpt = userRepository.findById(loginDTO.getEmail());

        if(userOpt.isEmpty()){
            return ResponseEntity.ok(Map.of(
                    "status" , "Unsuccessfull",
                    "Message" , "User doesn't exist"
            ));
        }

        UserModel user = userOpt.get();
        if(passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())){
            return ResponseEntity.ok(Map.of(
                    "status" , "Successfull",
                    "Message" , "Login Successful"
            ));
        }
        return ResponseEntity.ok(Map.of(
                "status" , "Unsuccessfull",
                "Message" , "Login failed because of password mismatch"
        ));
    }

    @Override
    public ResponseEntity<?> passwordReSet2(ChangePasswordDTO changePasswordDTO, String email){
        Optional<UserModel> user = userRepository.findById(email);
        if(user.isEmpty()){
            return ResponseEntity.status(404).body(Map.of(
                    "status", "Failed",
                    "message", "User not found"
            ));
        }

        UserModel newUser = user.get();

        newUser.setPassword(changePasswordDTO.getPassword());
        userRepository.save(newUser);

        return ResponseEntity.ok(Map.of(
                "status", "Successful",
                "message", "Password has been reset"
        ));

    }
}
