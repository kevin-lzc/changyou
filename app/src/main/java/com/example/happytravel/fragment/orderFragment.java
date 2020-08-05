package com.example.happytravel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.happytravel.Activity.RegisterAndLoginActivity;
import com.example.happytravel.R;

public class orderFragment extends Fragment {


    private View mOrderFragment;
    private View mGotoLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mOrderFragment = inflater.inflate(R.layout.order, container, false);
        initView();
        initListener();
        return mOrderFragment;
    }

    private void initListener() {
        mGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mOrderFragment.getContext(), RegisterAndLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mGotoLogin = mOrderFragment.findViewById(R.id.go_to_Login);
    }















}


