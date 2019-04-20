package com.technovation.mytutors;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class SavedPeopleRecyclerAdapter extends RecyclerView.Adapter<SavedPeopleRecyclerAdapter.myViewHolder> {

    private List<String> list;

    public SavedPeopleRecyclerAdapter(List<String>list){
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RelativeLayout profileView = (RelativeLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.profile_card_layout, viewGroup,false);

        myViewHolder viewHolder = new myViewHolder(profileView);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder viewHolder, int i) {
        String profile = list.get(i);
        String name = profile.split(",")[0];
        String pic = profile.split(",")[1];
        String ratingStr = (profile.split(",")[2]); // getting rating as a string

        float rating = Float.parseFloat(ratingStr);//changing rating from double to float

        viewHolder.textView.setText(name);
        viewHolder.ratingBar.setRating(rating);

    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout profileView;
        private ImageView imageView;
        private TextView textView;
        private RatingBar ratingBar;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profileView = (RelativeLayout)itemView;
            this.textView = this.profileView.findViewById(R.id.profileName);
            this.imageView = this.profileView.findViewById(R.id.profilePic);
            this.ratingBar = this.profileView.findViewById(R.id.ratingBar);
        }
    }
}
