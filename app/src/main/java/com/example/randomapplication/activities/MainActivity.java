package com.example.randomapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.randomapplication.R;
import com.example.randomapplication.retrofit.Models.Example;
import com.example.randomapplication.retrofit.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " );

        new Thread(new Runnable() {
            @Override
            public void run() {
                NetworkService
                        .getInstance()
                        .getJSONApi()
                        .getStringResponse(1)
                        .enqueue(new Callback<Example>() {
                            @Override
                            public void onResponse(Call<Example> call, Response<Example> response) {
                                Log.d(TAG, "onResponse: " );
                            }

                            @Override
                            public void onFailure(Call<Example> call, Throwable t) {
                                Log.d(TAG, "onFailure: "+ call.request().body() );
                            }
                        });

            }
        }).start();

    }
}
