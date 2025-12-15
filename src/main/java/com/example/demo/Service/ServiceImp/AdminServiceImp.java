package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Dto.ResponseHeadDTO;
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

//    @Override
//    public ResponseEntity<?> getAllUser() {
//        List<UserModel> users = userRepository.findAll();
//
//        if (users.isEmpty()) {
//            return ResponseEntity.ok(
//                    Map.of(
//                            "head", Map.of(
//                                    "status", "Successful",
//                                    "message", "No user found"
//                            ),
//                            "body", Map.of(
//                                    "users", List.of()
//                            )
//                    )
//            );
//        }
//
//        List<Map<String, Object>> userList = new ArrayList<>();
//
//        for (UserModel user : users) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("email", user.getEmail());
//            map.put("username", user.getUsername());
//            userList.add(map);
//        }
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "head", Map.of(
//                                "status", "Successful",
//                                "message", "User list fetched successfully"
//                        ),
//                        "body", Map.of(
//                                "users", userList
//                        )
//                )
//        );
//    }


    @Override
    public ResponseEntity<ResponseDTO<List<Map<String, Object>>>> getAllUser() {
        List<UserModel> userList = userRepository.findAll();
        List<Map<String , Object>> userMap = new ArrayList<>();

        for(UserModel user : userList){
            Map<String , Object> map = new HashMap<>();
            map.put("email" , user.getEmail());
            map.put("username" ,user.getUsername());
            userMap.add(map);
        }

        ResponseHeadDTO head = new ResponseHeadDTO(
                "Successfull" , "200" , userMap.isEmpty() ? "No users found" : "Users fetched successfully"
        );

        ResponseDTO<List<Map<String , Object>>> response = new ResponseDTO<>(head , userMap);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ResponseDTO<Map<String, Object>>> getUser(String email) {

        Optional<UserModel> userOpt = userRepository.findById(email);
        if(userOpt.isEmpty()){
            ResponseHeadDTO head = new ResponseHeadDTO(
                    "Unsuccesssfull" , "404" , "User not find"
            );

            ResponseDTO<Map<String , Object>> response = new ResponseDTO<>(head , null);
            return  ResponseEntity.status(400).body(response);
        }

        UserModel user = userOpt.get();
        Map<String , Object> map = new HashMap<>();
        map.put("email" , user.getEmail());
        map.put("username" , user.getUsername());

        ResponseHeadDTO head = new ResponseHeadDTO(
                "Successfull" , "200" , "User fetched successfully"
        );

        ResponseDTO<Map<String , Object>> response = new ResponseDTO<>(head , map);
        return ResponseEntity.ok(response);
    }

//    @Override
//    public ResponseEntity<?> getUser(String email) {
//        System.out.print(email);
//
//        Optional<UserModel> user = userRepository.findById(email);
//
//        if (user.isEmpty()) {
//            return ResponseEntity.status(404).body(Map.of(
//                    "status", "Unsuccessful",
//                    "message", "User not found for email: " + email
//            ));
//        }
//
//        UserModel userRes = user.get();
//        ResponseDTO responseDTO = new ResponseDTO(userRes.getEmail() , userRes.getUsername());
//        return ResponseEntity.ok(Map.of(
//                "body" , Map.of(
//                "user", responseDTO),
//                "head" , Map.of(
//                "status", "Successful")
//
//        ));
//    }


}
