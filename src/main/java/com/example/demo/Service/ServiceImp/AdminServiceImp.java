package com.example.demo.Service.ServiceImp;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> getAllUser() {
        List<UserModel> user = userRepository.findAll();

        if(user.isEmpty()){
            return ResponseEntity.ok(Map.of(
                    "status" , "Successfull",
                    "Message" , "No user found"
            ));
        }

        return ResponseEntity.ok(Map.of(
                "status" , "Successfull",
                "user" , user
        ));
    }

    @Override
    public ResponseEntity<?> getUser(String email) {
        System.out.print(email);

        Optional<UserModel> user = userRepository.findById(email);

        if (user.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "Unsuccessful",
                    "message", "User not found for email: " + email
            ));
        }

        return ResponseEntity.ok(Map.of(
                "status", "Successful",
                "user", user.get()
        ));
    }


}
