package com.example.randomapplication.presenters;
/*
 *
 */
import android.os.Bundle;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.randomapplication.enums.ResultEnum;
import com.example.randomapplication.views.IInformationView;
/**
 *
 */
@InjectViewState
public  class InformationPresenter
        extends MvpPresenter<IInformationView> {

    public void setString (Bundle bundle){
        String image = bundle.getString(ResultEnum.IMAGE_URL.getValue(), "");
        String text = String.format(" Name : %s \n Age :%s \n Phone : %s \n Email : %s \n Date :%s ",
                bundle.getString(ResultEnum.NAME.getValue(),""),
                bundle.getString(ResultEnum.AGE.getValue(),""),
                bundle.getString(ResultEnum.PHONE.getValue(),""),
                bundle.getString(ResultEnum.EMAIL.getValue(),""),
                bundle.getString(ResultEnum.DATE.getValue(),""));
        addImageUser(image);
        addTextUser(text);
    }

    private void addImageUser (String image){
        getViewState().setImageInformation(image);
    }

    private void addTextUser (String text){
        getViewState().setTextInformation(text);
    }
}
