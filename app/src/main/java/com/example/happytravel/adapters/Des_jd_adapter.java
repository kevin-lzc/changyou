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

public class Des_jd_adapter extends RecyclerView.Adapter<Des_jd_adapter.InnerHolder> {

    private final List<jpBean> mdespter;
    private OnItemClickListener mOnItemClickListener;

    public Des_jd_adapter(List<jpBean> fruitList) {
        mdespter =fruitList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpage_hot_jingdian_item, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        jpBean fruit = mdespter.get(position);
        holder.mImg_jingdian.setImageResource(fruit.getImageId());
        holder.mCity_name.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mdespter.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView mImg_jingdian;
        private TextView mCity_name;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mImg_jingdian = itemView.findViewById(R.id.Imag_jingdian);
            mCity_name = itemView.findViewById(R.id.city_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick();
                    }
                }
            });
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener =listener;
    }
    public interface OnItemClickListener{
        void onItemClick();
    }
}


