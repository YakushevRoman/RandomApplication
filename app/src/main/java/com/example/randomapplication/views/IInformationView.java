package com.example.randomapplication.views;

import android.os.Bundle;

import com.arellomobile.mvp.MvpView;

public interface IInformationView extends MvpView {
    void setImageInformation (String url);
    void setTextInformation (String information);
    void getBundle (Bundle bundle);
}
