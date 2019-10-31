package com.example.randomapplication.di.modules;

import com.example.randomapplication.fragments.ListUsersFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class ListUserModule {

    @Provides
    public ListUsersFragment getListUsersFragment(){
        return new ListUsersFragment();
    }
}
