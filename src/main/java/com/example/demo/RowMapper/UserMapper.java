package com.example.demo.RowMapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserMapper implements RowMapper<Map<String, Object>> {

    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {

        Map<String, Object> map = new HashMap<>();
        map.put("email", rs.getString("email"));
        map.put("username", rs.getString("username"));

        return map;
    }
}

