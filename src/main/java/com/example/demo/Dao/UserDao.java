package com.example.demo.Dao;

import com.example.demo.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
   JdbcTemplate UserJDBC;

    public List<Map<String , Object>> findAll(){
        return UserJDBC.query("Select * from User_Detail" , new UserMapper());
    }
}
