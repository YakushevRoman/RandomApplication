package com.example.randomapplication.retrofit;

import com.example.randomapplication.retrofit.Models.Example;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomRetrofitApi {

    @GET("/api/")
    Call<Example> getStringResponse (@Query("results") Integer results);

    @GET("/api/")
    Single<Example> getStringResponseRx (@Query("results") Integer results);
}
