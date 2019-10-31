package com.example.randomapplication.views;

import com.arellomobile.mvp.MvpView;
import com.example.randomapplication.retrofit.Models.Result;

import java.util.List;

public interface IListUsersView extends MvpView {

    void showListUsers (List<Result> resultUserList);
}
