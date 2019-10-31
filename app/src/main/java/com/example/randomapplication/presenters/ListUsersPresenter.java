package com.example.randomapplication.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.randomapplication.di.AppRandom;
import com.example.randomapplication.retrofit.Models.Example;
import com.example.randomapplication.retrofit.Models.Result;
import com.example.randomapplication.views.IListUsersView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.randomapplication.activities.MainActivity.TAG;

@InjectViewState
public class ListUsersPresenter extends MvpPresenter <IListUsersView> {

    public ListUsersPresenter() {
        getListUsersPresenter();
    }


    private void  getListUsersPresenter(){
        AppRandom
                .getRandomComponent()
                .getRandomRetrofitApi()
                .getStringResponse(5)
                .enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example =response.body();
                assert example != null;
                List<Result> result = example.getResults();
                Log.d(TAG, "onResponse: " + result.size());
                getViewState().showListUsers(result);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage() );
            }
        });
    }
}
