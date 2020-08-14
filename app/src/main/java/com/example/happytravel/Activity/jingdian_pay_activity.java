package com.example.happytravel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;

public class jingdian_pay_activity extends AppCompatActivity {

    private Button mJingdian_pay;
    private Button mBackto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pay_information);
        initView();
        initListener();
    }

    private void initListener() {
        mJingdian_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(jingdian_pay_activity.this);
                customDialog.setTitle("提醒");
                customDialog.setMessage("您的订单即将完成，是否确定？");
                customDialog.setCancel("cancel", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        finish();
                    }
                });
                customDialog.setConfirm("confirm", new CustomDialog.IOnConfirmListener(){
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Intent intent=new Intent(jingdian_pay_activity.this,pay_finish_activity.class);
                        startActivity(intent);
                    }
                });
                customDialog.show();
            }
        });
        mBackto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mJingdian_pay = this.findViewById(R.id.view_pay);
        mBackto = this.findViewById(R.id.view_pay_back);
    }
}


