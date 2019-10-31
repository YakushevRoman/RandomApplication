package com.example.randomapplication.retrofit.Models;
/*
 *
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 *
 */
public class Dob {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private int age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
