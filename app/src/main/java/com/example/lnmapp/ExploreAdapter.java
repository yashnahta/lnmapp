package com.example.lnmapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder> {

    private ArrayList<ExploreItem> mExploreList;

    public static class ExploreViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public  TextView textView;

        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.view_image);
            textView = itemView.findViewById(R.id.view_text1);
        }


    }

    public ExploreAdapter(ArrayList<ExploreItem> exploreList){
        mExploreList = exploreList;
    }

    @NonNull
    @Override
    public ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_item,parent,false);
        ExploreViewHolder evh = new ExploreViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewHolder holder, int position) {
        ExploreItem currentItem = mExploreList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView.setText(currentItem.getText1());


    }

    @Override
    public int getItemCount() {
        return mExploreList.size();
    }

}
