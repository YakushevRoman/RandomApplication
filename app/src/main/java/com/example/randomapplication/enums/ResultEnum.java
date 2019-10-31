package com.example.randomapplication.enums;
/**
 *
 */
public enum ResultEnum {

    NAME("Name"),
    DATE("Date"),
    AGE("Age"),
    EMAIL("Email"),
    PHONE("PhoneNumber"),
    IMAGE_URL("ImageUrl");

    private String value;

    ResultEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

