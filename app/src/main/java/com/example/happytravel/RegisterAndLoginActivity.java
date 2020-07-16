package com.example.happytravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class RegisterAndLoginActivity extends AppCompatActivity {
    Button WeChat_Login_api;
    Button Others_Login_api;
    Button Log_in;
    Button Sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_and_login);

//按钮绑定
        //WeChat_Login_api=(Button)findViewById();
        //Others_Login_api=(Button)findViewById();
        Log_in=(Button)findViewById(R.id.Log_in);
        Sign_up=(Button)findViewById(R.id.Sign_up);

//按钮监听
        Log_in.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegisterAndLoginActivity.this, RegisterActivity.class);
                RegisterAndLoginActivity.this.startActivity(intent);
            }
        });

//        Sign_up.setOnClickListener(new Button.OnClickListener(){
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(RegisterAndLoginActivity.this, SignUpActivity.class);
//                RegisterAndLoginActivity.this.startActivity(intent);
//            }
//        });
    }
}