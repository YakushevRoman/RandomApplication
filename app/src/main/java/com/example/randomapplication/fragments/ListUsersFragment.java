package com.example.randomapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.randomapplication.R;
import com.example.randomapplication.adapters.RandomAdapter;
import com.example.randomapplication.di.AppRandom;
import com.example.randomapplication.enums.ResultEnum;
import com.example.randomapplication.interfaces.IListUserFragment;
import com.example.randomapplication.presenters.ListUsersPresenter;
import com.example.randomapplication.retrofit.Models.Result;
import com.example.randomapplication.views.IListUsersView;
import java.util.List;


public  class ListUsersFragment
        extends MvpAppCompatFragment
        implements IListUsersView, IListUserFragment {

    @InjectPresenter
    ListUsersPresenter listUsersPresenter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_users_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_list_users);
    }


    @Override
    public void showListUsers(List<Result> resultUserList, RandomAdapter randomAdapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        randomAdapter.setListUsersAdapter(resultUserList);
        randomAdapter.setUserInformation(result -> {
            Fragment fragmentInformation = AppRandom.getRandomComponent().getInformationFragment();
            replaceFragment(fragmentInformation,result);
        });
        recyclerView.setAdapter(randomAdapter);
    }

    @Override
    public Bundle setBundle(Result result) {
        Bundle bundle = new Bundle();
        bundle.putString(ResultEnum.NAME.getValue(), String.format("Name   : %s %s %s",result.getName().getTitle(),result.getName().getFirst(),result.getName().getLast()));
        bundle.putString(ResultEnum.AGE.getValue(), String.format( "Age    : %s", result.getRegistered().getAge()));
        bundle.putString(ResultEnum.DATE.getValue(), String.format("Date   : %s", result.getRegistered().getDate()));
        bundle.putString(ResultEnum.EMAIL.getValue(), String.format("Email : %s", result.getEmail()));
        bundle.putString(ResultEnum.PHONE.getValue(), String.format("Phone : %s", result.getPhone()));
        bundle.putString(ResultEnum.IMAGE_URL.getValue(), result.getPicture().getLarge());
        return bundle;
    }

    @Override
    public void replaceFragment(Fragment fragment, Result result) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragmentContainer = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragmentManager.findFragmentById(R.id.fragment_container) != null){
            fragment.setArguments(setBundle(result));
            fragmentTransaction
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}

