package com.example.happytravel.Activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.happytravel.bean.Datas;
import com.example.happytravel.adapters.ListViewAdapter;


import com.example.happytravel.R;
import com.example.happytravel.fragment.jouneyphoto_fragmet;
import com.example.happytravel.fragment.mainPageFragment;
import com.example.happytravel.fragment.myCenterFragment;
import com.example.happytravel.fragment.orderFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private  RecyclerView mList;
    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;

    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;
    private mainPageFragment mMainPageFragment;
    private jouneyphoto_fragmet mJouneyphoto_fragmet;
    private orderFragment mOrderFragment;
    private myCenterFragment mMyCenterFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        mList=(RecyclerView) this.findViewById(R.id.recycler_view);
//        initData();
    }
    /**模拟数据*/
//    private void initData(){
//        List<ItemBean> mData = new ArrayList<>();
//
//        for(int i = 0; i< Datas.icons.length; i++){
//            ItemBean data=new ItemBean();
//            data.icon=Datas.icons[i];
//            data.title="我是第"+i+"条";
//            mData.add(data);
//        }
//        ListViewAdapter adapter=new ListViewAdapter(mData);
//        mList.setAdapter(adapter);
//    }

    private void initListener() {

    }


    private void initView() {
        // find view
        mViewPager = findViewById(R.id.fragment_vp);
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        // init fragment

        mMainPageFragment = new mainPageFragment();
        mJouneyphoto_fragmet = new jouneyphoto_fragmet();
        mOrderFragment = new orderFragment();
        mMyCenterFragment = new myCenterFragment();
        mFragments = new ArrayList<>(4);
        mFragments.add(mMainPageFragment);
        mFragments.add(mJouneyphoto_fragmet);
        mFragments.add(mOrderFragment);
        mFragments.add(mMyCenterFragment);
        // init view pager
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        // register listener
        mViewPager.addOnPageChangeListener(mPageChangeListener);
        mTabRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.removeOnPageChangeListener(mPageChangeListener);
    }

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            RadioButton radioButton = (RadioButton) mTabRadioGroup.getChildAt(position);
            radioButton.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            for (int i = 0; i < group.getChildCount(); i++) {
                if (group.getChildAt(i).getId() == checkedId) {
                    mViewPager.setCurrentItem(i);
                    return;
                }
            }
        }
    };
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mList = list;
        }
        @Override
        public Fragment getItem(int position) {
            return this.mList == null ? null : this.mList.get(position);
        }
        @Override
        public int getCount() {
            return this.mList == null ? 0 : this.mList.size();
        }
    }
}