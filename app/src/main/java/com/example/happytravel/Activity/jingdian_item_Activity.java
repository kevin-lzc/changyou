package com.example.happytravel.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;

public class jingdian_item_Activity extends AppCompatActivity {

    private Button mGoto_order;
    private ImageView mViewById;
    private Button mAdd_to_order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jingdian_item);
        initView();
        initListener();
    }

    private void initListener() {
        mAdd_to_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(jingdian_item_Activity.this);
                customDialog.setTitle("提示");
                customDialog.setMessage("是否将此订单进行收藏？");
                customDialog.setCancel("cancel", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        finish();
                    }
                });
                customDialog.setConfirm("confirm", new CustomDialog.IOnConfirmListener(){
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Toast.makeText(jingdian_item_Activity.this,"订单收藏成功",Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.show();
            }
        });
        mGoto_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(jingdian_item_Activity.this,jingdian_pay_activity.class);
                startActivity(intent);
            }
        });
        mViewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mAdd_to_order = this.findViewById(R.id.add_order);
        mGoto_order = this.findViewById(R.id.go_to_order);
        mViewById = this.findViewById(R.id.goback);
    }
}


