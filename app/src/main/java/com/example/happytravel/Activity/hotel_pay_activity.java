package com.example.happytravel.Activity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;

public class hotel_pay_activity extends AppCompatActivity {

    private Button mHotel_pay_bt;
    private Button mBack_hotel;
    private Button mHotel_buycar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_pay_information);
        initView();
       initListener();
    }

   private void initListener() {
        mHotel_buycar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(hotel_pay_activity.this);
                customDialog.setTitle("提醒");
                customDialog.setMessage("是否收藏此酒店？");
                customDialog.setCancel("cancel", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        finish();
                    }
                });
                customDialog.setConfirm("confirm", new CustomDialog.IOnConfirmListener(){
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                     Toast.makeText(hotel_pay_activity.this,"酒店收藏成功",Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.show();
            }
        });
        mBack_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHotel_pay_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(hotel_pay_activity.this);
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
                        Intent intent=new Intent(hotel_pay_activity.this,pay_finish_activity.class);
                        startActivity(intent);
                    }
                });
                customDialog.show();
            }
        });
    }

    private void initView() {
        mHotel_buycar = this.findViewById(R.id.hotel_shopping_cart);
        mHotel_pay_bt = this.findViewById(R.id.hotel_pay);
        mBack_hotel = this.findViewById(R.id.hotel_pay_back);
    }
}


