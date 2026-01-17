package com.example.demo.Service.ServiceImp;

import com.example.demo.Dao.EmployeeDao;
import com.example.demo.Dto.RequestDTO;
import com.example.demo.Dto.ResponseDTO;
import com.example.demo.Dto.ResponseHeadDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import com.example.demo.RowMapper.UserMapper;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeServiceImp  implements EmployeeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public ResponseEntity<ResponseDTO<Map<String, Object>>> getEmployee(RequestDTO requestDTO) {
        UserModel userModel = new UserModel();
        userModel.setEmail(requestDTO.getEmail());

        if(userRepository.findById(requestDTO.getEmail()).isEmpty()){
            ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                    "Unsuccessfull" , 400 , "User not found.");
            ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO ,
                    null);
            return ResponseEntity.ok(responseDTO);
        }

        ResponseHeadDTO responseHeadDTO = new ResponseHeadDTO(
                "Successfull" , 200 , "Fetched Successfully Dao");
        ResponseDTO<Map<String , Object>> responseDTO = new ResponseDTO<>(responseHeadDTO ,
                employeeDao.allEmployee(userModel));
        return ResponseEntity.ok(responseDTO);
    }
}
