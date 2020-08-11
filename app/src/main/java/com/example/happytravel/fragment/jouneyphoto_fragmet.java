package com.example.happytravel.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.happytravel.Activity.jp_se2;
import com.example.happytravel.R;
import com.example.happytravel.adapters.jpAdapter;
import com.example.happytravel.bean.jpBean;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;

import java.util.ArrayList;
import java.util.List;

public class jouneyphoto_fragmet extends Fragment implements WbShareCallback {
    private List<jpBean> fruitList = new ArrayList<>();
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
    private RecyclerView mRecyclerView;
    private jpAdapter mJpAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mJouney_photo_fragment = inflater.inflate(R.layout.jouneyphoto, container, false);
        initView();
        initData();
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
        mRecyclerView = mJouney_photo_fragment.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mJpAdapter = new jpAdapter(fruitList);
        mRecyclerView.setAdapter(mJpAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom=10;
                outRect.top=10;
            }
        });
    }


    private void initData() {
        for (int i = 0; i < 2; i++) {
            jpBean apple = new jpBean("Apple", R.mipmap.bengjing1);
            fruitList.add(apple);
            jpBean banana = new jpBean("Banana", R.mipmap.bengjing1);
            fruitList.add(banana);
            jpBean orange = new jpBean("Orange", R.mipmap.bengjing1);
            fruitList.add(orange);
            jpBean watermelon = new jpBean("Watermelon",R.mipmap.bengjing1);
            fruitList.add(watermelon);
            jpBean pear = new jpBean("Pear",R.mipmap.bengjing1);
            fruitList.add(pear);
            jpBean grape = new jpBean("Grape", R.mipmap.bengjing1);
            fruitList.add(grape);
            jpBean pineapple = new jpBean("Pineapple", R.mipmap.bengjing1);
            fruitList.add(pineapple);
            jpBean strawberry = new jpBean("Strawberry", R.mipmap.bengjing1);
            fruitList.add(strawberry);
            jpBean cherry = new jpBean("Cherry", R.mipmap.bengjing1);
            fruitList.add(cherry);
            jpBean mango = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);
            jpBean mang = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);
            jpBean man = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);
            jpBean mngo = new jpBean("Mango", R.mipmap.bengjing1);
            fruitList.add(mango);

        }
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


