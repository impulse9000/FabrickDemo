package com.example.fabrick.models;

public class TransactionType {
    private String enumeration;
    private String value;

    public TransactionType(String enumeration, String value) {
        this.enumeration = enumeration;
        this.value = value;
    }

    public String getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
