package com.example.randomapplication.retrofit.Models;
/*
 *
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*
 *
 */
public class Street {

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("name")
    @Expose
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
