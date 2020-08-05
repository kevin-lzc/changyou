package com.example.happytravel.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.happytravel.R;
import com.example.happytravel.register.OpenHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private String realCode;
    private OpenHelper mOpenHelper;
    private Button mRegisterButton;
    private Button mRegisterBack;
    private LinearLayout mRegisterBody;
    private EditText mRegisterUsername;
    private EditText mRegisterPassword1;
    private EditText mRegisterPassword2;
    private AppCompatCheckBox mRegisterAgree;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        initView();
        mOpenHelper= new OpenHelper(this);
    }


    private void initView() {
        mRegisterUsername=findViewById(R.id.register_username);
        mRegisterPassword1=findViewById(R.id.register_password1);
        mRegisterPassword2=findViewById(R.id.register_password2);
        mRegisterBody=findViewById(R.id.register_body);
        mRegisterBack=findViewById(R.id.register_back);
        mRegisterButton=findViewById(R.id.register_button);
        mRegisterAgree=findViewById(R.id.register_agree);
        mRegisterAgree.setOnClickListener(this);
        mRegisterBack.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.register_back: //返回登录页面
                Intent intent1 = new Intent(this, RegisterAndLoginActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.register_button:    //注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = mRegisterUsername.getText().toString().trim();
                String password = mRegisterPassword1.getText().toString().trim();
                String pswd2 = mRegisterPassword2.getText().toString().trim();

                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)&& !TextUtils.isEmpty(pswd2) && password.equals(pswd2)) {

                    //将用户名和密码加入到数据库中
                    mOpenHelper.add(username, password);
                    Intent intent2 = new Intent(this, LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "未完善信息，或两次密码不一致，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
