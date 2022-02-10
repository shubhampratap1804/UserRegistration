package com.example.dto;


public class ResponseDTO {
    public String message;
    public Object models;

    public ResponseDTO(String message, Object models) {
        this.message = message;
        this.models = models;
    }
}
