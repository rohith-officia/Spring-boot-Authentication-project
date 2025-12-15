package com.example.demo.Dto;

public class ResponseDTO<T> {
//    private final String email;
//    private final String username;
//
//    public ResponseDTO(String email, String username) {
//        this.email = email;
//        this.username = username;
//    }
//
//    public String getEmail() { return email; }
//    public String getUsername() { return username; }

    public ResponseHeadDTO head;
    public T body;

    public ResponseDTO(){

    }

    public ResponseDTO(ResponseHeadDTO head , T body){
        this.head = head;
        this.body = body;
    }

    public ResponseHeadDTO getHead() {
        return head;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setHead(ResponseHeadDTO head) {
        this.head = head;
    }
}
