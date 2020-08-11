package com.example.happytravel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.R;
import com.example.happytravel.bean.jpBean;

import java.util.List;

public class des_hotel_point_heigh_adapter extends RecyclerView.Adapter<des_hotel_point_heigh_adapter.InnerHolder> {

    private final List<jpBean> mHotel_JpBeans;

    public des_hotel_point_heigh_adapter(List<jpBean> fruitList) {
        mHotel_JpBeans =fruitList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_list_item, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        jpBean fruit = mHotel_JpBeans.get(position);
        holder.mHotel_img.setImageResource(fruit.getImageId());
        holder.mHotel_name.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mHotel_JpBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mHotel_img;
        private final TextView mHotel_name;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mHotel_img = itemView.findViewById(R.id.hotel_image);
            mHotel_name = itemView.findViewById(R.id.hotel_name);
        }
    }
}


