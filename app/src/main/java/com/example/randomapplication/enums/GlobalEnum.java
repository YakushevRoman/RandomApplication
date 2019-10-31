package com.example.randomapplication.enums;

public enum GlobalEnum {
    TAG ("RandomApp");

    private String value;

    GlobalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
