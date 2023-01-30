package com.example.image_scanning.bean;


public class AddScanDataResponseBean {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuccess_code() {
        return success_code;
    }

    public void setSuccess_code(String success_code) {
        this.success_code = success_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String status;
    private String success_code;
    private String message;
}
