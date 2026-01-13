package com.example.demo.Dao;

import com.example.demo.DButil.Query;
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
        System.out.print(Query.FIND_ALL_USERS);
        return UserJDBC.query(Query.FIND_ALL_USERS, new UserMapper());
    }

    public int save(UserModel userModel){
        System.out.print(Query.CREATE_NEW_USER);
//        System.out.print(userModel.getEmail());
        return UserJDBC.update(Query.CREATE_NEW_USER , userModel.getEmail() , userModel.getUsername() , userModel.getPassword());
    }
}
