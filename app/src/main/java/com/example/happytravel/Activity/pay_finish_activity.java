package com.example.happytravel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;
import com.example.happytravel.fragment.mainPageFragment;

public class pay_finish_activity extends AppCompatActivity {

    private Button mBack_to_mainPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_finish_page);
        initView();
        initListener();
    }

    private void initListener() {
        mBack_to_mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pay_finish_activity.this, MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
                pay_finish_activity.this.finish();
            }
        });
    }

    private void initView() {
        mBack_to_mainPage = this.findViewById(R.id.back_to_main_page);
    }
}


