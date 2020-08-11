package com.example.happytravel.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.happytravel.R;
import com.example.happytravel.fragment.fragment_hotel;
import com.example.happytravel.fragment.fragment_jingdian;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationActivity extends AppCompatActivity {
    private String title[] = new String[]{"景点", "酒店"};
    private MagicIndicator mMagicIndicator;
    private ViewPager mViewPager;
    private MyAdapter myAdapter;
    private ImageView mDestination_back_btn;
    @BindView(R.id.search_btn)
      public ImageView DestinationSearchBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_page);
        ButterKnife.bind(this);
        initView();
        initListener();
        initMagicIndicator();
    }

    private void initListener() {
        DestinationSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DestinationActivity.this,baidu_MapActivity.class);
                startActivity(intent);
            }
        });
        mDestination_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mDestination_back_btn = this.findViewById(R.id.destination_back_btn);
        mMagicIndicator = this.findViewById(R.id.MagicIndicator);
        mViewPager = this.findViewById(R.id.ViewPager);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myAdapter);
        //设置监听
     mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             mMagicIndicator.onPageScrolled(position,positionOffset,positionOffsetPixels);
         }
         @Override
         public void onPageSelected(int position) {
          mMagicIndicator.onPageSelected(position);
         }

         @Override
         public void onPageScrollStateChanged(int state) {
             mMagicIndicator.onPageScrollStateChanged(state);
         }
     });
    }

    private CommonPagerTitleView initMagicIndicator() {
        mMagicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setFollowTouch(true);
        commonNavigator.setAdjustMode(true);
             commonNavigator.setScrollPivotX(0.5f);
             commonNavigator.setEnablePivotScroll(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter()
        {
             public int getCount() {
                            return title == null ? 0 : title.length;//
                            }
                            @Override
                            public IPagerTitleView getTitleView(Context context, final int index)
                            {
             //设置Magicindicator的一种标题模式， 标题模式有很多种，这是最基本的一种
             SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);//
             simplePagerTitleView.setText(title[index]);//                //设置被选中的item颜色//
             simplePagerTitleView.setSelectedColor(Color.RED);//                //设置为被选中item颜色//
             simplePagerTitleView.setNormalColor(Color.GRAY);//
             simplePagerTitleView.setTextSize(25);
             simplePagerTitleView.setPadding(160,1,120,1);
             simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mViewPager.setCurrentItem(index);
             }
             });
             return simplePagerTitleView;
             }          @Override
             public IPagerIndicator getIndicator(Context context) {
            // 设置标题指示器，也有多种,可不选，即没有标题指示器。
             BezierPagerIndicator indicator = new BezierPagerIndicator(context);//
             indicator.setColors(Color.parseColor("#ff4a42"), Color.parseColor("#fcde64"), Color.parseColor("#73e8f4")
                                    , Color.parseColor("#76b0ff"), Color.parseColor("#c683fe")
                                    , Color.parseColor("#76b0ff"), Color.parseColor("#c683fe")
                                    , Color.parseColor("#76b0ff"), Color.parseColor("#c683fe"));
                                    return null;
                                               }
        });
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMagicIndicator, mViewPager);
        return null;
    }
            private class MyAdapter extends FragmentPagerAdapter {
                public MyAdapter(FragmentManager fm) {
                    super(fm);
                }
/*
设置两个碎片用于放置酒店和景点
 */
                @Override
                public Fragment getItem(int position) {
                    Fragment fragment = null;
                    switch (position) {
                        case 0://当position等于0的时候，就显示第一个碎片
                            fragment_jingdian fragmentOne = new fragment_jingdian();
                            fragment = fragmentOne;
                            break;
                        case 1://当position等于1的时候，就显示第二个碎片
                            fragment_hotel fragmentTwo = new fragment_hotel();
                            fragment = fragmentTwo;
                            break;
                    }
                    return fragment;
                }
                @Override
                public int getCount() {
                    return title.length;
                }
                @Override
                public CharSequence getPageTitle(int position) {
                    return title[position];
                }
            }
        }

