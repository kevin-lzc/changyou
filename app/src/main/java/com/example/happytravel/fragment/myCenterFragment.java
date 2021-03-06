package com.example.happytravel.fragment;

import android.content.Intent;
import android.net.LinkAddress;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.happytravel.Activity.MyStoreActivity;
import com.example.happytravel.Activity.history_activity;
import com.example.happytravel.Activity.my_jouney_photo_activity;
import com.example.happytravel.Global_Variable;
import com.example.happytravel.R;

public class myCenterFragment extends Fragment {
    private View myCenterFragment;
    private View mView;
    private LinearLayout mHistoryOrder;
    private LinearLayout mView1;
    private LinearLayout mMystore;
    private LinearLayout mMyPhotoj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(((Global_Variable) getActivity().getApplication()).getflag_login()==true){
            //登陆后的界面
            mView = inflater.inflate(R.layout.my_center_login_after, container, false);
            initView();
            initListener();
            return mView;
        }
        else {
            //登陆前界面
            myCenterFragment = inflater.inflate(R.layout.my_center, container, false);
            initView1();
            initListener1();
        }

        return myCenterFragment;
    }

    private void initListener1() {

    }

    private void initView1() {
        mView1 = myCenterFragment.findViewById(R.id.my_center2);

    }

    private void initListener() {
        mMyPhotoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         Intent intent=new Intent(mView.getContext(), my_jouney_photo_activity.class);
         startActivity(intent);
            }
        });
        mHistoryOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mView.getContext(), history_activity.class);
                startActivity(intent);
            }
        });
        mMystore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mView.getContext(), MyStoreActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mMyPhotoj = mView.findViewById(R.id.my_center4);
        mMystore = mView.findViewById(R.id.my_center3);
        mHistoryOrder = mView.findViewById(R.id.my_center2);
    }
}


