package com.example.happytravel.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class hot_jingdian_recycleview_adapter extends RecyclerView.Adapter<hot_jingdian_recycleview_adapter.InnerHoolder> {
    @NonNull
    @Override
    public InnerHoolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHoolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InnerHoolder extends RecyclerView.ViewHolder {
        public InnerHoolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}


