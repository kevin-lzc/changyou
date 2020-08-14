package com.example.happytravel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.Activity.hotel_item_activity;
import com.example.happytravel.R;
import com.example.happytravel.adapters.des_hotel_close_adapter;
import com.example.happytravel.adapters.des_hotel_point_heigh_adapter;
import com.example.happytravel.bean.jpBean;

import java.util.ArrayList;
import java.util.List;

public class fragment_hotel extends Fragment {
    private List<jpBean> fruitList = new ArrayList<>();
    private View mHotel_fragment;
    private RecyclerView mCloest_me_reclerView;
    private RecyclerView mPointHeightest;
    private des_hotel_close_adapter mDes_hotel_close_adapter;
    private des_hotel_point_heigh_adapter mDes_hotel_point_heigh_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mHotel_fragment = inflater.inflate(R.layout.hotel_list_page, container, false);
        initView();
        initData();
        initListener();
        return mHotel_fragment;
    }

    private void initListener() {
        mDes_hotel_close_adapter.setOnClickListener(new des_hotel_close_adapter.OnClickListener() {
            @Override
            public void itemClick() {
                Intent intent=new Intent(mHotel_fragment.getContext(), hotel_item_activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mCloest_me_reclerView = mHotel_fragment.findViewById(R.id.closest_me);
        mPointHeightest = mHotel_fragment.findViewById(R.id.point_heightest);
        mCloest_me_reclerView.setLayoutManager(new LinearLayoutManager(mHotel_fragment.getContext()));
        mDes_hotel_close_adapter = new des_hotel_close_adapter(fruitList);
        mCloest_me_reclerView.setAdapter(mDes_hotel_close_adapter);
        mPointHeightest.setLayoutManager(new LinearLayoutManager(mHotel_fragment.getContext()));
        mDes_hotel_point_heigh_adapter = new des_hotel_point_heigh_adapter(fruitList);
        mPointHeightest.setAdapter(mDes_hotel_point_heigh_adapter);
    }
    private void initData() {
        for (int i = 0; i < 2; i++) {
            jpBean apple = new jpBean("北京金沙酒店", R.mipmap.hotel1);
            fruitList.add(apple);
            jpBean banana = new jpBean("北京橄榄绿酒店", R.mipmap.hotel2);
            fruitList.add(banana);
            jpBean orange = new jpBean("拉萨蔚来酒店", R.mipmap.weilaihotel);
            fruitList.add(orange);
            jpBean watermelon = new jpBean("平康错酒店",R.mipmap.hotel_lasa);
            fruitList.add(watermelon);

        }
    }
}


