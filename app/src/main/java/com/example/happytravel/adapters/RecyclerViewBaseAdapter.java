package com.example.happytravel.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.happytravel.R;
import com.example.happytravel.bean.ItemBean;

import java.util.List;


public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {
    private final List<ItemBean> mData;

    public RecyclerViewBaseAdapter(List<ItemBean>data){
       this.mData=data;

   }


    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=getSubView(parent,viewType);
        return new InnerHolder(view);
    }

    protected abstract View getSubView(ViewGroup parent,int viewType);

    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {

        holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {

        if(mData!= null){
            return mData.size();
        }
        return 0;
    }
    public class InnerHolder extends  RecyclerView.ViewHolder{
        private ImageView mIcon;
        private TextView mTitle;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ImageView mIcon=itemView.findViewById(R.id.icon);
            TextView mTitle=itemView.findViewById(R.id.title);
        }

        public void setData(ItemBean itemBean) {
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }

}
