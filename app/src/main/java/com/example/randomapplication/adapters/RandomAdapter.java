package com.example.randomapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.randomapplication.R;
import com.example.randomapplication.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class RandomAdapter  extends RecyclerView.Adapter<RandomAdapter.RandomHolder> {
    private List<UserModel> userList;

    public RandomAdapter() {
        this.userList = new ArrayList<>();
    }

    public void setListUsersAdapter (List<UserModel> newListUsers){
        userList.clear();
        userList.addAll(newListUsers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RandomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_users, viewGroup, false);
        return new RandomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomHolder randomHolder, int i) {
        randomHolder.bindListUser(userList.get(i));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

     class RandomHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewUser;
        private TextView textViewUser;

         RandomHolder(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.image_list_users_recycler);
            textViewUser = itemView.findViewById(R.id.txt_list_users_recycler);
        }

        void bindListUser(UserModel userModel){
            imageViewUser.setImageResource(R.drawable.ic_launcher_background);
            textViewUser.setText(userModel.getName());
        }
    }
}
