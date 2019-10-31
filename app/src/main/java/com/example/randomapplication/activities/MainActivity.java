package com.example.randomapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.randomapplication.R;
import com.example.randomapplication.di.AppRandom;
import com.example.randomapplication.fragments.ListUsersFragment;
import com.example.randomapplication.interfaces.IAddFragment;

public class MainActivity
        extends AppCompatActivity
        implements IAddFragment {
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " );
        Fragment fragmentListUsers = AppRandom
                .getRandomComponent()
                .getListUsersFragment();
        addFragment(fragmentListUsers);

    }

    @Override
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragmentContainer = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragmentContainer == null){
            fragmentTransaction
                    .add(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();

        }
    }

}
