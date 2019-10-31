package com.example.randomapplication.presenters;
/*
 *
 */
import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.randomapplication.adapters.RandomAdapter;
import com.example.randomapplication.di.AppRandom;
import com.example.randomapplication.enums.GlobalEnum;
import com.example.randomapplication.retrofit.Models.Result;
import com.example.randomapplication.views.IListUsersView;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 *
 */
@InjectViewState
public  class ListUsersPresenter
        extends MvpPresenter <IListUsersView> {

    private RandomAdapter randomAdapter;

    public ListUsersPresenter() {
        randomAdapter = AppRandom
                .getRandomComponent()
                .getAdapterModule();
        getListUsersPresenter();
    }


    private void  getListUsersPresenter(){
       Disposable disposable = AppRandom
               .getRandomComponent()
               .getRandomRetrofitApi()
               .getStringResponseRx(1)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(example -> {
                   List<Result> result = example.getResults();
                   Log.d(GlobalEnum.TAG.getValue(), "onResponse: " + result.size());
                   getViewState().showListUsers(result, randomAdapter);
               });
        disposable.isDisposed();
    }
}
