package com.example.fabrick.models;

public class BaseResponse {
    private String status;
    private FabrickError[] errors;

    public BaseResponse(String status, FabrickError[] errors) {
        this.status = status;
        this.errors = errors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FabrickError[] getErrors() {
        return errors;
    }

    public void setErrors(FabrickError[] errors) {
        this.errors = errors;
    }
}
