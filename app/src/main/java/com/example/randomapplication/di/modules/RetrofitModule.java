package com.example.randomapplication.di.modules;

import com.example.randomapplication.retrofit.RandomRetrofitApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Singleton
    @Provides
    Retrofit getRetrofit () {
        return new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    RandomRetrofitApi getRandomRetrofitApi(Retrofit retrofit){
        return retrofit.create(RandomRetrofitApi.class);
    }
}
