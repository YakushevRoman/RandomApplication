package com.example.randomapplication.activities;
/*
 *
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.randomapplication.R;
import com.example.randomapplication.di.AppRandom;
import com.example.randomapplication.enums.GlobalEnum;
import com.example.randomapplication.interfaces.IAddFragment;
/**
 *
 */
public  class MainActivity
        extends AppCompatActivity
        implements IAddFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(GlobalEnum.TAG.getValue(), "onCreate: " );

        Fragment fragmentListUsers = AppRandom
                .getRandomComponent()
                .getListUsersFragment();
        addFragment(fragmentListUsers);
    }

    @Override
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentManager.findFragmentById(R.id.fragment_container) == null){
            fragmentTransaction
                    .add(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
