package com.example.randomapplication.interfaces;
/*
 *
 */
import com.example.randomapplication.retrofit.Models.Result;
import java.util.List;
/**
 *
 */
public interface IAddFunctionalRecycler {

    void  setUserInformation (IClickRecycler iClickRecycler);
    void setListUsersAdapter (List<Result> newListUsers);

}
