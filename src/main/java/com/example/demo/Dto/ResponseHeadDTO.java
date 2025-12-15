package com.example.demo.Dto;

public class ResponseHeadDTO {
    private String status;
    private String statusCode;
    private String message;

    public ResponseHeadDTO() {

    }

    public ResponseHeadDTO(String status , String statusCode , String message){
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
