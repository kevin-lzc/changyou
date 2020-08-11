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

import com.example.happytravel.Activity.jingdian_item_Activity;
import com.example.happytravel.R;
import com.example.happytravel.adapters.Des_jd_adapter;
import com.example.happytravel.bean.jpBean;

import java.util.ArrayList;
import java.util.List;

public class fragment_jingdian extends Fragment {
    private List<jpBean> fruitList = new ArrayList<>();
    private View mJingdian_fragment;
    private RecyclerView mDes_jd_recycle;
    private Des_jd_adapter mDes_jd_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mJingdian_fragment = inflater.inflate(R.layout.jingdian_list_page, container, false);
        initView();
        initData();
        initListener();
        return mJingdian_fragment;
    }

    private void initListener() {
        mDes_jd_adapter.setOnItemClickListener(new Des_jd_adapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Intent intent=new Intent(mJingdian_fragment.getContext(), jingdian_item_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mDes_jd_recycle = mJingdian_fragment.findViewById(R.id.des_jingdian_recyclerView);
        mDes_jd_recycle.setLayoutManager(new LinearLayoutManager(mJingdian_fragment.getContext()));
        mDes_jd_adapter = new Des_jd_adapter(fruitList);
        mDes_jd_recycle.setAdapter(mDes_jd_adapter);
    }
    private void initData() {
        for (int i = 0; i < 2; i++) {
            jpBean apple = new jpBean("Apple", R.mipmap.bengjing1);
            fruitList.add(apple);
            jpBean banana = new jpBean("Banana", R.mipmap.bengjing1);
            fruitList.add(banana);
            jpBean orange = new jpBean("Orange", R.mipmap.bengjing1);
            fruitList.add(orange);
            jpBean watermelon = new jpBean("Watermelon",R.mipmap.bengjing1);
            fruitList.add(watermelon);
            jpBean pear = new jpBean("Pear",R.mipmap.bengjing1);
            fruitList.add(pear);
            jpBean grape = new jpBean("Grape", R.mipmap.bengjing1);
            fruitList.add(grape);
            jpBean pineapple = new jpBean("Pineapple", R.mipmap.bengjing1);
            fruitList.add(pineapple);
            jpBean strawberry = new jpBean("Strawberry", R.mipmap.bengjing1);
            fruitList.add(strawberry);
            jpBean cherry = new jpBean("Cherry", R.mipmap.bengjing1);
            fruitList.add(cherry);
            jpBean mango = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);
            jpBean mang = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);
            jpBean man = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);
            jpBean mngo = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);

        }
    }





}


