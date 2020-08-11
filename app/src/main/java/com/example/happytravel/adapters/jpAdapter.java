package com.example.happytravel.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.Activity.jp_se2;
import com.example.happytravel.R;
import com.example.happytravel.bean.jpBean;

import java.util.List;

public class jpAdapter  extends RecyclerView.Adapter<jpAdapter.ViewHolder> {
    private final List<jpBean> mJpBeans;
    private int mInt;

    public jpAdapter(List<jpBean> fruitList) {
        mJpBeans =fruitList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView fruitImage;
    TextView fruitName;

    public ViewHolder (View view)
    {
        super(view);
        fruitImage = view.findViewById(R.id.jp_img);
        fruitName =  view.findViewById(R.id.jp_location);
        fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(
                new Intent(v.getContext(), jp_se2.class),
                        // 注意这里的sharedView
                        // Content，View（动画作用view），String（和XML一样）
ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), fruitImage, "jp").toBundle());
            }
        });
    }

}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_jouneyphoto,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        mInt =position;
        jpBean fruit = mJpBeans.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount(){
        return mJpBeans.size();
    }

} 


