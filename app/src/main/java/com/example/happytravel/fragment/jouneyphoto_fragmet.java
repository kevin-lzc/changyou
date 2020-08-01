package com.example.happytravel.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.happytravel.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;

public class jouneyphoto_fragmet extends Fragment implements WbShareCallback {

    private View mJouney_photo_fragment;
    private FloatingActionButton mCommit_weibo;
    //在微博开发平台为应用申请的App Key
    private static final String APP_KY = "2341576114";
    //在微博开放平台设置的授权回调页
    private static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    //在微博开放平台为应用申请的高级权限
    private static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
    private IWBAPI mWbapi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mJouney_photo_fragment = inflater.inflate(R.layout.jouneyphoto, container, false);
        initView();
        initListener();
        return mJouney_photo_fragment;
    }

    private void initListener() {
        mCommit_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doWeiboShare();
            }
        });
    }

    private void initView(){
        mCommit_weibo = mJouney_photo_fragment.findViewById(R.id.fb);
        mWbapi = WBAPIFactory.createWBAPI(mJouney_photo_fragment.getContext());
    }

    private void doWeiboShare() {
        WeiboMultiMessage message = new WeiboMultiMessage();
        TextObject textObject = new TextObject();
        String text = "我正在使用微博客户端发博器分享文字。";
        // 分享文字
        text = "这里设置您要分享的内容！";
        textObject.text = text;
        message.textObject = textObject;
        // 分享图片
        ImageObject imageObject = new ImageObject();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        imageObject.setImageData(bitmap);
        message.imageObject = imageObject;
        mWbapi.shareMessage(message, true);
    }

@Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mWbapi.doResultIntent(data, (WbShareCallback) mJouney_photo_fragment.getContext());
    }

    @Override
    public void onComplete() {
        Toast.makeText(mJouney_photo_fragment.getContext(), "分享成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(UiError uiError) {

        Toast.makeText(mJouney_photo_fragment.getContext(), "分享失败:" + uiError.errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel() {
        Toast.makeText(mJouney_photo_fragment.getContext(), "分享取消", Toast.LENGTH_SHORT).show();
    }
}


