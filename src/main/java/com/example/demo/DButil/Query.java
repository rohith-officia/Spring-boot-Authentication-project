package com.example.demo.DButil;

public final class Query {

    public static final String FIND_ALL_USERS  = "Select * from User_Detail";
    public static final String CREATE_NEW_USER = "INSERT INTO User_Detail VALUES (?, ?, ?)";
}
