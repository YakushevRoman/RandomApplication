package com.example.randomapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.randomapplication.R;
import com.example.randomapplication.enums.ResultEnum;
import com.example.randomapplication.presenters.InformationPresenter;
import com.example.randomapplication.views.IInformationView;
import com.squareup.picasso.Picasso;

public class InformationFragment extends MvpAppCompatFragment implements IInformationView {

    private Bundle bundle;
    private ImageView imageView;
    private TextView textView;

    private String url;
    private String information;
    @InjectPresenter
    InformationPresenter informationPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        url = bundle.getString(ResultEnum.IMAGE_URL.getValue(), "");
        information = bundle.getString(ResultEnum.NAME.getValue(),"") + "\n" +
                bundle.getString(ResultEnum.AGE.getValue(),"") + "\n" +
                bundle.getString(ResultEnum.PHONE.getValue(),"") + "\n" +
                bundle.getString(ResultEnum.EMAIL.getValue(),"") + "\n" +
                bundle.getString(ResultEnum.DATE.getValue(),"") + "\n";

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.information_user_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.image_information);
        textView = view.findViewById(R.id.txt_information);

        Picasso.get().load(url).into(imageView);
        textView.setText(information);
    }

    @Override
    public void setImageInformation(String url) {

    }

    @Override
    public void setTextInformation(String information) {

    }

    @Override
    public void getBundle(Bundle bundle) {

    }
}