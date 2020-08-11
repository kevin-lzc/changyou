package com.example.happytravel.adapters;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.Activity.hotel_pay_activity;
import com.example.happytravel.R;
import com.example.happytravel.bean.jpBean;

import org.w3c.dom.Text;

import java.util.List;

public class hotel_chose_adapter extends RecyclerView.Adapter<hotel_chose_adapter.InnerHolder> {

    private final List<jpBean> mJpBeans;

    public hotel_chose_adapter(List<jpBean> fruitList) {
        mJpBeans =fruitList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_chose_item, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        jpBean fruit = mJpBeans.get(position);
        holder.mHotel_img.setImageResource(fruit.getImageId());
        holder.mHotel_price.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mJpBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mHotel_img;
        private final TextView mHotel_price;
        private final Button mGo_to_order;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mHotel_img = itemView.findViewById(R.id.hotel_chose_img);
            mHotel_price = itemView.findViewById(R.id.hotel_price);
            mGo_to_order = itemView.findViewById(R.id.go_to_order);
            mGo_to_order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), hotel_pay_activity.class);
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}


