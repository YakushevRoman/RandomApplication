package com.example.randomapplication.adapters;
/*
 *
 */
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.randomapplication.R;
import com.example.randomapplication.interfaces.IClickRecycler;
import com.example.randomapplication.retrofit.Models.Result;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public  class RandomAdapter
        extends RecyclerView.Adapter<RandomAdapter.RandomHolder> {

    private List<Result> userList;
    private  IClickRecycler iClickRecycler;

    public RandomAdapter() {
        this.userList = new ArrayList<>();
    }

    public void  setUserInformation (IClickRecycler iClickRecycler){
        this.iClickRecycler = iClickRecycler;
    }

    public void setListUsersAdapter (List<Result> newListUsers){
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

        void bindListUser(final Result result){
            Picasso .get()
                    .load(result.getPicture().getLarge())
                    .into(imageViewUser);
            textViewUser.setText(String.format("User:\n%s %s %s ",
                            result.getName().getTitle(),
                            result.getName().getFirst(),
                            result.getName().getLast()));
            textViewUser.setOnClickListener(v -> iClickRecycler.clickRecyclerItem(result));
            imageViewUser.setOnClickListener(v -> iClickRecycler.clickRecyclerItem(result));
        }
    }
}
