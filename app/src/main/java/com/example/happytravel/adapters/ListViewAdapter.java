package com.example.happytravel.adapters;

import android.graphics.ImageDecoder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.R;
import com.example.happytravel.bean.ItemBean;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {
public final List<ItemBean> mData;
public ListViewAdapter(List<ItemBean> data){
    this.mData=data;
}

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = View.inflate(parent.getContext(), R.layout.jouneyphoto,null);
    return new InnerHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

    holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {

    if(mData!= null){
        return mData.size();
    }
    return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
    private ImageView mIcon;
    private TextView mTitle;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ImageView mIcon=itemView.findViewById(R.id.jp);
            TextView mTitle=itemView.findViewById(R.id.jp);
        }

        public void setData(ItemBean itemBean) {
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);

        }
    }
}
