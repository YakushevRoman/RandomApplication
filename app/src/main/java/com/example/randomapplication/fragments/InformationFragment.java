package com.example.randomapplication.fragments;
/*
 *
 */
import android.content.Context;
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
import com.example.randomapplication.presenters.InformationPresenter;
import com.example.randomapplication.views.IInformationView;
import com.squareup.picasso.Picasso;
/**
 *
 */
public  class InformationFragment
        extends MvpAppCompatFragment
        implements IInformationView {

    @InjectPresenter
    InformationPresenter informationPresenter;

    private ImageView imageView;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            informationPresenter.setString(bundle);
        }
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
    }

    @Override
    public void setImageInformation(String imageInformation) {
        Picasso .get()
                .load(imageInformation)
                .placeholder(R.drawable.gradient)
                .into(imageView);
    }

    @Override
    public void setTextInformation(String information) {
        textView.setText(information);
    }

}