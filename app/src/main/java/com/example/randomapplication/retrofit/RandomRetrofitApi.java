package com.example.randomapplication.retrofit;

import com.example.randomapplication.retrofit.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomRetrofitApi {
    @GET("/api/")
    Call<Example> getStringResponse (@Query("results") Integer results);
}
