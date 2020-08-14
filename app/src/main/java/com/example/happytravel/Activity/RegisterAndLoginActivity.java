package com.example.happytravel.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MicrophoneInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.happytravel.R;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

import net.lucode.hackware.magicindicator.MagicIndicator;

public class RegisterAndLoginActivity extends AppCompatActivity {

    private ImageView mWe_bo_login;
    //在微博开发平台为应用申请的App Key
    private static final String APP_KY = "2341576114";
    //在微博开放平台设置的授权回调页
    private static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    //在微博开放平台为应用申请的高级权限
    private static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
    private IWBAPI mWBAPI;
    private Button mLog_in;
    private Button mSign_up;
    private ImageView mWechat_login;

    private VideoView myVideo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_and_login);
        myVideo = (VideoView) findViewById(R.id.videoView);
        initView();
        initListener();
    }
    private void init_weibo_sdk() {
        //初始化SDK
        AuthInfo authInfo = new AuthInfo(this, APP_KY, REDIRECT_URL, SCOPE);
        mWBAPI = WBAPIFactory.createWBAPI(this);
        mWBAPI.registerApp(this,authInfo);
    }
    //开始进行微博授权
    private void startClientAuth() {
        mWBAPI.authorizeClient(new WbAuthListener() {
            @Override
            public void onComplete(Oauth2AccessToken token) {
                Toast.makeText(RegisterAndLoginActivity.this, "微博授权成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(UiError error) {
                Toast.makeText(RegisterAndLoginActivity.this, "微博授权出错", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(RegisterAndLoginActivity.this, "微博授权取消", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mWBAPI != null) {
            mWBAPI.authorizeCallback(requestCode,resultCode,data);
        }
        Intent intent=new Intent(RegisterAndLoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void initView() {
        mWe_bo_login = this.findViewById(R.id.Others_Login_api);
        //按钮绑定
        mLog_in = this.findViewById(R.id.Log_in);
        mSign_up = this.findViewById(R.id.Sign_up);
        mWechat_login = this.findViewById(R.id.wechat_logo);
        //播放路径
        myVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.login_background));
        //播放
        myVideo.start();
        //循环播放
        myVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                myVideo.start();
            }
        });
    }

    private void initListener() {


        mWechat_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterAndLoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//按钮监听
        mLog_in.setOnClickListener(new Button.OnClickListener(){
        public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegisterAndLoginActivity.this, LoginActivity.class);
                RegisterAndLoginActivity.this.startActivity(intent);
                }
                });

                mSign_up.setOnClickListener(new Button.OnClickListener(){
        public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegisterAndLoginActivity.this, RegisterActivity.class);
                RegisterAndLoginActivity.this.startActivity(intent);
    }
        });
        mWe_bo_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init_weibo_sdk();
                startClientAuth();
            }
        });


}
}