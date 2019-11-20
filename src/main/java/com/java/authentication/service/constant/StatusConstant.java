package com.java.authentication.service.constant;

public enum StatusConstant {
    FAILED("failed"),SUCCESS("success");

    private String message;

    StatusConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
