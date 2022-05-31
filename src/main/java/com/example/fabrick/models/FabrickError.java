package com.example.fabrick.models;

public class FabrickError {
    private String code;
    private String description;
    private String params;

    public FabrickError(String code, String description, String params) {
        this.code = code;
        this.description = description;
        this.params = params;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
