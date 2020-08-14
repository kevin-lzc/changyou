package com.example.happytravel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.R;
import com.example.happytravel.adapters.hotel_chose_adapter;
import com.example.happytravel.bean.jpBean;

import java.util.ArrayList;
import java.util.List;

public class hotel_item_activity extends AppCompatActivity {
    private List<jpBean> fruitList = new ArrayList<>();
    private RecyclerView mHotel_chose_recyclerView;
    private hotel_chose_adapter mHotel_chose_adapter;
    private LinearLayout mHotel_goto_baidu;
    private ImageView mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_item);
        initView();
        initListener();
        initData();
    }

    private void initListener() {

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHotel_goto_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hotel_item_activity.this,baidu_SearchPlaceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mBack = this.findViewById(R.id.back_to_last);
        mHotel_goto_baidu = this.findViewById(R.id.hotel_goto_baidu);
        mHotel_chose_recyclerView = this.findViewById(R.id.hotel_chose_recyclerView);
        mHotel_chose_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHotel_chose_adapter = new hotel_chose_adapter(fruitList);
        mHotel_chose_recyclerView.setAdapter(mHotel_chose_adapter);
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


