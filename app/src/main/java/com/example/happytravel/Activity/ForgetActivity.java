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

import com.example.happytravel.Activity.LoginActivity;
import com.example.happytravel.Activity.MainPageActivity;
import com.example.happytravel.Activity.RegisterAndLoginActivity;
import com.example.happytravel.R;
import com.example.happytravel.register.OpenHelper;
import com.example.happytravel.register.User;

import java.util.ArrayList;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private String realCode;
    private OpenHelper mOpenHelper;
    private Button mCheckAccount;
    private Button mResetPassword;
    private Button mForgetBack;
    private EditText mForgetUsername;
    private EditText mForgetPassword1;
    private EditText mForgetPassword2;
    private LinearLayout  mForgetBody;

    private void initView() {
        mForgetUsername=findViewById(R.id.forget_password_username);
        mForgetPassword1=findViewById(R.id.reset_password1);
        mForgetPassword2=findViewById(R.id.reset_password2);
        mForgetBody=findViewById(R.id.forget_body);
        mForgetBack=findViewById(R.id.forget_back);
        mCheckAccount=findViewById(R.id.check_account);
        mResetPassword=findViewById(R.id.reset_password);
        mCheckAccount.setOnClickListener(this);
        mResetPassword.setOnClickListener(this);
        mForgetBack.setOnClickListener(this);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        initView();
        mOpenHelper= new OpenHelper(this);
    }


    @Override
    public void onClick(View view) {
        String username = mForgetUsername.getText().toString().trim();
        String password = mForgetPassword1.getText().toString().trim();
        String pswd2 = mForgetPassword2.getText().toString().trim();

        switch (view.getId()){
            case R.id.forget_back: //返回登录页面
                Intent intent1 = new Intent(this, RegisterAndLoginActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.check_account:

                if (!TextUtils.isEmpty(username)) {
                    ArrayList<User> data = mOpenHelper.getAllData();
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if (username.equals(user.getName()) ) {
                            match = true;
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(this, "验证成功", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "用户名不存在", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                }
                break;



                    case R.id.reset_password:

                if ( !TextUtils.isEmpty(password)&& !TextUtils.isEmpty(pswd2) && password.equals(pswd2)) {

                    //将用户名和密码加入到数据库中
                    mOpenHelper.update(password);
                    Intent intent2 = new Intent(this, LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    Toast.makeText(this, "重设密码成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "检查信息是否完整 或 两次密码是否一致", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
