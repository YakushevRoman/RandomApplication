package com.example.randomapplication.di;

import android.content.Context;

import com.example.randomapplication.adapters.RandomAdapter;
import com.example.randomapplication.di.modules.AdapterModule;
import com.example.randomapplication.di.modules.ContextModule;
import com.example.randomapplication.di.modules.InformationUserModule;
import com.example.randomapplication.di.modules.ListUserModule;
import com.example.randomapplication.di.modules.RetrofitModule;
import com.example.randomapplication.fragments.InformationFragment;
import com.example.randomapplication.fragments.ListUsersFragment;
import com.example.randomapplication.retrofit.RandomRetrofitApi;

import javax.inject.Singleton;
import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {
        ContextModule.class,
        RetrofitModule.class,
        ListUserModule.class,
        InformationUserModule.class,
        AdapterModule.class})
public interface  RandomComponent {
    Context getContext();
    Retrofit getRetrofit();
    RandomRetrofitApi getRandomRetrofitApi();
    ListUsersFragment getListUsersFragment();
    InformationFragment getInformationFragment();
    RandomAdapter getAdapterModule();
}
