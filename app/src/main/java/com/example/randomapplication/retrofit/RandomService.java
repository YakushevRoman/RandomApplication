package com.example.randomapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomService {

    private static RandomService mInstance;
    private static final String BASE_URL = "https://randomuser.me";
    private Retrofit mRetrofit;

    private RandomService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RandomService getInstance() {
        if (mInstance == null) {
            mInstance = new RandomService();
        }
        return mInstance;
    }

    public RandomRetrofitApi RandomRetrofitApi() {
        return mRetrofit.create(RandomRetrofitApi.class);
    }
}
