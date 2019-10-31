package com.example.randomapplication.di;

import android.app.Application;

import com.example.randomapplication.di.modules.ContextModule;

public class AppRandom  extends Application {

    private static RandomComponent randomComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        randomComponent = DaggerRandomComponent
                .builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public static RandomComponent getRandomComponent(){
        return randomComponent;
    }

}
