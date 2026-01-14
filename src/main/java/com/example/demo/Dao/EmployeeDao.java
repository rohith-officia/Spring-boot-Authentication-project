package com.example.demo.Dao;

import com.example.demo.DButil.Query;
import com.example.demo.Model.UserModel;
import com.example.demo.RowMapper.EmployeeMapper;
import com.example.demo.RowMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate Employeejdbc;


    public Map<String , Object> allEmployee(UserModel userModel){
        System.out.print(userModel.getEmail());
            return Employeejdbc.queryForMap(Query.FIND_EMPLOYEE_BY_EMAIL , userModel.getEmail());

    }
}
