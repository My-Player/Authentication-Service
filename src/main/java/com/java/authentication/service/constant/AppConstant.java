package com.java.authentication.service.constant;

public enum AppConstant {
    HEADER("header");

    private String message;

    AppConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
