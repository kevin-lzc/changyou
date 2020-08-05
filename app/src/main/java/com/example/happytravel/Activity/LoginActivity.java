package com.example.happytravel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.happytravel.R;
import com.example.happytravel.register.OpenHelper;
import com.example.happytravel.register.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private OpenHelper mOpenHelper;
    private Button mLoginButton;
    private Button mLoginBack;
    private Button mLoginForgetPassword;
    private LinearLayout mLoginBody;
    private EditText mLoginUsername;
    private EditText mLoginPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
        mOpenHelper = new OpenHelper(this);
    }

    private void initView() {
        mLoginForgetPassword=findViewById(R.id.login_forget_password);
        mLoginButton = findViewById(R.id.login_button);
        mLoginBack = findViewById(R.id.login_back);
        mLoginUsername = findViewById(R.id.login_username);
        mLoginPassword = findViewById(R.id.login_password);
        mLoginButton.setOnClickListener(this);
        mLoginForgetPassword.setOnClickListener(this);
        mLoginBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.login_back: //返回登录页面
                Intent intent1 = new Intent(this, RegisterAndLoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.login_forget_password:
                Intent intent2 = new Intent(this, ForgetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.login_button:
                String username = mLoginUsername.getText().toString().trim();
                String password = mLoginPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    ArrayList<User> data = mOpenHelper.getAllData();
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if (username.equals(user.getName()) && password.equals(user.getPassword())) {
                            match = true;
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();//销毁此Activity
                    } else {
                        Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
                break;


        }



    }


}
