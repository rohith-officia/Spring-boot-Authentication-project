package com.example.demo.Service.ServiceImp;

import com.example.demo.Dao.EmployeeDao;
import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Dto.ResponseHeadDTO;
import com.example.demo.Model.StudentModels;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Service
public class EmployeeServiceImp  implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImp.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public ResponseEntity<ResponseDTO<Map<String, Object>>> getEmployee(RequestDTO requestDTO) {

        String userServiceUrl = "http://localhost:8080/userdetail/{email}/";

/*        StudentModels studentModel = null;
        studentModel = restTemplate.getForObject(
                userServiceUrl,   // URL
                StudentModels.class,  // Response type
                requestDTO.getEmail() // Path variable
        );

        System.out.print(studentModel);*/


        Map<String , Object> map = restTemplate.getForObject(
                userServiceUrl,   // URL
                Map.class,  // Response type
                requestDTO.getEmail() // Path variable
        );

        System.out.print(map);

            UserModel userModel = new UserModel();
            userModel.setEmail(requestDTO.getEmail());

        if (userRepository.findById(requestDTO.getEmail()).isEmpty()) {
                ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                        "Unsuccessfull", 400, "User not found.");
                ResponseDTO<Map<String, Object>> responseDTO = new ResponseDTO<>(responseHeadDTO,
                        null);
                return ResponseEntity.ok(responseDTO);
            }

        log.info("User exists, fetching employee details for email={}", requestDTO.getEmail());
            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                    "Successfull", 200, "Fetched Successfully Dao");
            ResponseDTO<Map<String, Object>> responseDTO = new ResponseDTO<>(responseHeadDTO,
                    employeeDao.allEmployee(userModel));
            return ResponseEntity.ok(responseDTO);
        }
}
