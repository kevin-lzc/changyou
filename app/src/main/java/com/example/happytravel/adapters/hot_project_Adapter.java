package com.example.happytravel.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.R;
import com.example.happytravel.bean.jpBean;

import org.w3c.dom.Text;

import java.util.List;

public class hot_project_Adapter extends RecyclerView.Adapter<hot_project_Adapter.InnnerHolder> {
    private final List<jpBean> mPJpBeans;
    private OnclickItemListener setOnclickListener=null;
    private OnclickItemListener mSetOnclickListener;
    private int mposition;

    public hot_project_Adapter(List<jpBean> fruitList) {
        mPJpBeans =fruitList;
    }

    @NonNull
    @Override
    public InnnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_page_hot_project_itemview, parent, false);
        return new InnnerHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull InnnerHolder holder, int position) {
          mposition =position;
        jpBean fruit = mPJpBeans.get(position);
        holder.mProImg.setImageResource(fruit.getImageId());
        holder.mProText.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class InnnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mProImg;
        private final TextView mProText;

        public InnnerHolder(@NonNull View itemView) {
            super(itemView);
            mProImg = itemView.findViewById(R.id.proImg);
            mProText = itemView.findViewById(R.id.proText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mSetOnclickListener != null) {
                        mSetOnclickListener.onItemClick(mposition);
                    }
                }
            });
        }
    }
    public void setOnclickItemListener(OnclickItemListener listener){
        mSetOnclickListener = this.setOnclickListener;
        mSetOnclickListener =listener;
    }


    public interface OnclickItemListener{
        void onItemClick(int position);
    }
}


