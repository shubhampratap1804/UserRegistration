package com.example.exception;

public class BusinessException extends Exception {
    private String message;

    public BusinessException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}