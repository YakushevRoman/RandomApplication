package com.example.randomapplication.di.modules;
/*
 *
 */
import com.example.randomapplication.fragments.InformationFragment;
import dagger.Module;
import dagger.Provides;
/**
 *
 */
@Module
public class InformationUserModule {

    @Provides
    InformationFragment getInformationFragment(){
        return new InformationFragment();
    }

}
