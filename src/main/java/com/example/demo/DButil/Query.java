package com.example.demo.DButil;

public final class Query {

    public static final String FIND_ALL_USERS  = "Select * from User_Detail";
    public static final String CREATE_NEW_USER = "INSERT INTO User_Detail (email , username , password) VALUES (?, ?, ?)";

    public static final String FIND_EMPLOYEE_BY_EMAIL =
            "SELECT " +
                    "u.email, " +
                    "u.username, " +
                    "e.role " +
                    "FROM User_Detail u " +
                    "INNER JOIN employees e " +
                    "ON u.email = e.user_email " +
                    "WHERE u.email = ?";


}
