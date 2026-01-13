package com.example.demo.Service.ServiceImp;

import com.example.demo.Dao.UserDao;
import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Dto.ResponseHeadDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdminService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                "Successfull" , 200 , userMap.isEmpty() ? "No users found" : "Users fetched successfully"
        );

        ResponseDTO<List<Map<String , Object>>> response = new ResponseDTO<>(head , userMap);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ResponseDTO<Map<String, Object>>> getUser(String email) {

        Optional<UserModel> userOpt = userRepository.findById(email);
        if(userOpt.isEmpty()){
            ResponseHeadDTO head = new ResponseHeadDTO(
                    "Unsuccesssfull" , 400 , "User not find"
            );

            ResponseDTO<Map<String , Object>> response = new ResponseDTO<>(head , null);
            return  ResponseEntity.status(400).body(response);
        }

        UserModel user = userOpt.get();
        Map<String , Object> map = new HashMap<>();
        map.put("email" , user.getEmail());
        map.put("username" , user.getUsername());

        ResponseHeadDTO head = new ResponseHeadDTO(
                "Successfull" , 200 , "User fetched successfully"
        );

        ResponseDTO<Map<String , Object>> response = new ResponseDTO<>(head , map);
        return ResponseEntity.ok(response);
    }


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<ResponseDTO<Map<String, Object>>> addUser(Map<String, String> body) {

            String email = body.get("email");
            String username = body.get("username");
            String password = body.get("password");

            if(email == null || username == null || password == null){
                ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                        "Unsuccessfull" , 400 , "Invalid Input");

                ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO,null);
                return ResponseEntity.ok(responseDTO);
            }

        if(userRepository.existsById(email)) {
            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                    "Unsuccessfull" , 400 , "User already exsist");

            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO,null);
            return ResponseEntity.ok(responseDTO);
        }

        else{
            UserModel user = new UserModel();
            user.setPassword(passwordEncoder.encode(password));
            user.setUsername(username);
            user.setEmail(email);

            userRepository.save(user);

            Map<String , Object> map = new HashMap<>();
            map.put("Username" , user.getUsername());
            map.put("Email" , user.getEmail());

            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO("Successfull" , 200 , "Fetch successful");

            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO , map);

            return ResponseEntity.ok(responseDTO);

        }

    }

    @Override
    public ResponseEntity<ResponseDTO<Map<String, Object>>> addNewUser(RequestDTO requestDTO) {

        String email = requestDTO.getEmail();
        String username = requestDTO.getUsername();
        String password = requestDTO.getPassword();

        if(email == null || username == null || password == null){
            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                    "Unsuccessfull" , 400 , "Invalid Input");

            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO,null);
            return ResponseEntity.ok(responseDTO);
        }

        if(userRepository.existsById(email)) {
            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                    "Unsuccessfull" , 400 , "User already exsist");

            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO,null);
            return ResponseEntity.ok(responseDTO);
        }

        else{
            UserModel user = new UserModel();
            user.setPassword(passwordEncoder.encode(password));
            user.setUsername(username);
            user.setEmail(email);

            userRepository.save(user);

            Map<String , Object> map = new HashMap<>();
            map.put("Username" , user.getUsername());
            map.put("Email" , user.getEmail());

            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO("Successfull" , 200 , "Fetch successful");

            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO , map);

            return ResponseEntity.ok(responseDTO);

        }
    }

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<ResponseDTO<List<Map<String, Object>>>> getAllUserDao() {
        ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO("Successfull" , 200 , "Fetch successful");
        ResponseDTO <List<Map<String , Object>>> responseDTO = new ResponseDTO<>(responseHeadDTO , userDao.findAll());
        return ResponseEntity.ok(responseDTO);

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
