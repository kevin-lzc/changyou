package com.example.happytravel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.happytravel.R;
import com.example.happytravel.bean.ImageBean;
import com.example.happytravel.bean.jpBean;

import java.util.ArrayList;
import java.util.List;

public class hot_jingdian_recycleview_adapter extends RecyclerView.Adapter<hot_jingdian_recycleview_adapter.InnerHolder> {


    private final List<jpBean> mJpBeans;
    private OnItemClickListener mOnItemClickListener=null;
    private int mPosition;

    public hot_jingdian_recycleview_adapter(List<jpBean> fruitList) {
        mJpBeans =fruitList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpage_hot_jingdian_item, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        jpBean fruit = mJpBeans.get(position);
        holder.mImg_jingdian.setImageResource(fruit.getImageId());
        holder.mCity_name.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return 10;
    }




    public class InnerHolder extends RecyclerView.ViewHolder {

        private  ImageView mImg_jingdian;
        private  TextView mCity_name;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mImg_jingdian = itemView.findViewById(R.id.Imag_jingdian);
            mCity_name = itemView.findViewById(R.id.city_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });
        }
    }

         public void setOnItemClickListener(OnItemClickListener listener){
                  mOnItemClickListener =listener;
         }

    public interface OnItemClickListener{
        void onItemClick(int position);

    }
}


