package com.example.randomapplication.interfaces;
/*
 *
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.example.randomapplication.retrofit.Models.Result;
/**
 *
 */
public interface IListUserFragment {

    Bundle setBundle (Result result);
    void replaceFragment (Fragment fragment, Result result);

}
