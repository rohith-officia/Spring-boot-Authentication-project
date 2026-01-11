package com.example.demo.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseHeadDTO {
    private String status;
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    public ResponseHeadDTO() {

    }

    public ResponseHeadDTO(String status , int statusCode , String message){
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
