package com.example.happytravel.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.happytravel.Activity.RegisterAndLoginActivity;
import com.example.happytravel.Activity.orderactivity;
import com.example.happytravel.Global_Variable;
import com.example.happytravel.R;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class orderFragment extends Fragment {
    private View mOrderFragment1;
    private View mGotoLogin;
    private View mView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //登陆逻辑实现 判断是否登陆 fragment 调用全局变量application
        if(((Global_Variable) getActivity().getApplication()).getflag_login()==true){
            //登陆后的界面
            //测试界面
            mView2 = inflater.inflate(R.layout.second_login_order_page, container, false);
            return mView2;

        }
        else {
            //登陆前界面
            mOrderFragment1 = inflater.inflate(R.layout.order, container, false);
             initView();
             initListener();
            return mOrderFragment1;

        }
    }

    private void initListener() {
        mGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mOrderFragment1.getContext(), RegisterAndLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mGotoLogin = mOrderFragment1.findViewById(R.id.enter_now);

    }
















}


