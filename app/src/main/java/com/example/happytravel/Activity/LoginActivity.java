package com.example.happytravel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin_btn;
    private TextView mForget_password_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
       initListener();
 }

   private void initListener() {
        


       mLogin_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(LoginActivity.this,MainActivity.class);
               startActivity(intent);
           }
       });}


    private void initView() {
        mLogin_btn = this.findViewById(R.id.loginPage_login);
        mForget_password_btn = this.findViewById(R.id.forget_password);
    }


}
