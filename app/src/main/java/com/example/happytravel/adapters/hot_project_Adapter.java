package com.example.happytravel.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class hot_project_Adapter extends RecyclerView.Adapter<hot_project_Adapter.InnnerHolder> {
    @NonNull
    @Override
    public InnnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InnnerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InnnerHolder extends RecyclerView.ViewHolder {
        public InnnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}


