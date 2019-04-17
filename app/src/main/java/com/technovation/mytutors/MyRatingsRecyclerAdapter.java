package com.technovation.mytutors;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MyRatingsRecyclerAdapter {/* extends RecyclerView.Adapter<MyRatingsRecyclerAdapter.myViewHolder>  {

    private List<String> list;

    public MyRatingsRecyclerAdapter(List<String>list){
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RelativeLayout profileView = (RelativeLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rating_card_layout, viewGroup,false);

        myViewHolder viewHolder = new myViewHolder(profileView);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageRecyclerAdapter.myViewHolder viewHolder, int i) {
        String profile = list.get(i);
        String name = profile.split(",")[0];
        String pic = profile.split(",")[1];
        String review = profile.split(",")[3];

        viewHolder.textView.setText(name);

    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout profileView;
        private ImageView imageView;
        private TextView textView;
        private TextView review;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profileView = (RelativeLayout)itemView;
            this.textView = this.profileView.findViewById(R.id.ReviewerName);
            this.imageView = this.profileView.findViewById(R.id.ReviewProfilePicture);
            this.review = this.profileView.findViewById(R.id.review);
        }
    }
    */
}
