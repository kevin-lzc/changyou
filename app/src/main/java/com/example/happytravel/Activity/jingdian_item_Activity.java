package com.example.happytravel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;

public class jingdian_item_Activity extends AppCompatActivity {

    private Button mGoto_order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jingdian_item);
        initView();
        initListener();
    }

    private void initListener() {
        mGoto_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(jingdian_item_Activity.this,jingdian_pay_activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mGoto_order = this.findViewById(R.id.go_to_order);
    }
}


