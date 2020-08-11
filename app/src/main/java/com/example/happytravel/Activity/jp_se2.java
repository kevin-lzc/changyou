package com.example.happytravel.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.happytravel.R;

public class jp_se2 extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView1;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_jp_large);
        initView();
    }

    private void initView() {
        mImageView1=findViewById(R.id.jp2);
        mImageView1.setOnClickListener( this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jp2:
                // 注意这里不使用finish
                ActivityCompat.finishAfterTransition(jp_se2.this);
        }
    }
}
