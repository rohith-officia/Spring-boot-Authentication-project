package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdminService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> getAllUser() {
        List<UserModel> users = userRepository.findAll();

        if (users.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of(
                            "head", Map.of(
                                    "status", "Successful",
                                    "message", "No user found"
                            ),
                            "body", Map.of(
                                    "users", List.of()
                            )
                    )
            );
        }

        List<Map<String, Object>> userList = new ArrayList<>();

        for (UserModel user : users) {
            Map<String, Object> map = new HashMap<>();
            map.put("email", user.getEmail());
            map.put("username", user.getUsername());
            userList.add(map);
        }

        return ResponseEntity.ok(
                Map.of(
                        "head", Map.of(
                                "status", "Successful",
                                "message", "User list fetched successfully"
                        ),
                        "body", Map.of(
                                "users", userList
                        )
                )
        );
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

        UserModel userRes = user.get();
        ResponseDTO responseDTO = new ResponseDTO(userRes.getEmail() , userRes.getUsername());
        return ResponseEntity.ok(Map.of(
                "body" , Map.of(
                "user", responseDTO),
                "head" , Map.of(
                "status", "Successful")

        ));
    }


}
