package com.example.happytravel.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class LooperPagerAdapter extends PagerAdapter {
    private List<Integer> sPics;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition=position%sPics.size();
        ImageView imageView=new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);//将图片拉伸到屏幕大小
        imageView.setImageResource(sPics.get(realPosition));
        //imageView.setBackgroundColor(mColors.get(realPosition));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        if(sPics!=null){
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;//默认这么敲
    }

    public int getDataRealSize(){
        if (sPics != null) {
            return sPics.size();
        }
        return 0;
    }

    public void setData(List<Integer> colos) {
        this.sPics=colos;
    }
}


