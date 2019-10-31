package com.example.randomapplication.di.modules;
/*
 *
 */
import com.example.randomapplication.adapters.RandomAdapter;
import dagger.Module;
import dagger.Provides;
/**
 *
 */
@Module
public class AdapterModule {

    @Provides
    RandomAdapter randomAdapter (){
        return new RandomAdapter();
    }

}
