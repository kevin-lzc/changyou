package com.example.happytravel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.happytravel.Activity.DestinationActivity;
import com.example.happytravel.Activity.RegisterAndLoginActivity;
import com.example.happytravel.R;
import com.example.happytravel.adapters.LooperPagerAdapter;
import com.example.happytravel.adapters.hot_jingdian_recycleview_adapter;
import com.example.happytravel.adapters.hot_project_Adapter;

public class mainPageFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private View mMainPage_fragment;
    private TextView mLookmore;
    private Button mMainPage_goto_login;
    private ViewPager mMainPage_looper;
    private LooperPagerAdapter mLooperPagerAdapter;
    private RecyclerView mHot_jingdian_recycleView;
    private hot_jingdian_recycleview_adapter mHot_jingdian_recycleview_adapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mHot_jingdian_project_recycleView;
    private hot_project_Adapter mHot_project_adapter;

    //    private  static List<Integer> spics=new ArrayList<>();
//static {
//spics.add()
//spics.add()
//spics.add()
//}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMainPage_fragment = inflater.inflate(R.layout.main_page, container, false);
        initView();
        initListener();
        return mMainPage_fragment;
    }

    private void initListener() {
        mLookmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mMainPage_fragment.getContext(), DestinationActivity.class);
                startActivity(intent);
            }
        });
        mMainPage_goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mMainPage_fragment.getContext(), RegisterAndLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mLookmore = mMainPage_fragment.findViewById(R.id.lookMore);
        mMainPage_goto_login = mMainPage_fragment.findViewById(R.id.mainPage_goto_login);
        mMainPage_looper = mMainPage_fragment.findViewById(R.id.main_page_looper);
        mLooperPagerAdapter = new LooperPagerAdapter();
        mMainPage_looper.setAdapter(mLooperPagerAdapter);

        mMainPage_looper.addOnPageChangeListener(this);

       /*
       设置景点的RecycleView
        */
        mHot_jingdian_recycleView = mMainPage_fragment.findViewById(R.id.hot_jingdian_recycleView);
        mLinearLayoutManager = new LinearLayoutManager(mMainPage_fragment.getContext(),RecyclerView.HORIZONTAL,false);
        mHot_jingdian_recycleView.setLayoutManager(mLinearLayoutManager);//设置景点的RecycleView的展示方向和滑动的方向
        mHot_jingdian_recycleview_adapter = new hot_jingdian_recycleview_adapter();
        mHot_jingdian_recycleView.setAdapter(mHot_jingdian_recycleview_adapter);
       /*
       设置热门项目的RecycleView
       */
        mHot_jingdian_project_recycleView = mMainPage_fragment.findViewById(R.id.hot_jingdian_project);
        mHot_jingdian_project_recycleView.setLayoutManager(new LinearLayoutManager(mMainPage_fragment.getContext(),RecyclerView.HORIZONTAL,false));
        mHot_project_adapter = new hot_project_Adapter();
        mHot_jingdian_project_recycleView.setAdapter(mHot_project_adapter);
     }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}


