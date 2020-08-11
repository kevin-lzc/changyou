package com.example.happytravel.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.happytravel.Activity.DestinationActivity;
import com.example.happytravel.Activity.RegisterAndLoginActivity;
import com.example.happytravel.Activity.baidu_SearchPlaceActivity;
import com.example.happytravel.Activity.jingdian_item_Activity;
import com.example.happytravel.R;
import com.example.happytravel.adapters.LooperPagerAdapter;
import com.example.happytravel.adapters.hot_jingdian_recycleview_adapter;
import com.example.happytravel.adapters.hot_project_Adapter;
import com.example.happytravel.baidu_MainActivity;
import com.example.happytravel.bean.ImageBean;
import com.example.happytravel.bean.jpBean;
import com.example.happytravel.utils.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class mainPageFragment extends Fragment implements ViewPager.OnPageChangeListener, MyViewPager.onViewPagerTouchListener{
    private View mMainPage_fragment;
    private List<jpBean> fruitList = new ArrayList<>();
    private TextView mLookmore;
    private Button mMainPage_goto_login;
    private LooperPagerAdapter mLooperPagerAdapter;
    private static final String TAG = "Main_ViewPager_Activity";
    private MyViewPager LooperPager;
    private boolean misTouch=false;
    private LinearLayout mPointsContainer;
    private static List<Integer> spics=new ArrayList<>();//定义一个集合放3张图片
    static {
        spics.add(R.mipmap.bengjing2);
        spics.add(R.mipmap.bengjing1);
        spics.add(R.mipmap.bengjing3);
        spics.add(R.mipmap.lasa2);
        spics.add(R.mipmap.lasa3);
        spics.add(R.mipmap.xiamen1);
        spics.add(R.mipmap.xiamen3);
        spics.add(R.mipmap.xiamen2);
    }
    private RecyclerView mHot_jingdian_recycleView;
    private hot_jingdian_recycleview_adapter mHot_jingdian_recycleview_adapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mHot_jingdian_project_recycleView;
    private hot_project_Adapter mHot_project_adapter;
    @BindView(R.id.main_search_btn)
    public ImageView mainSearchBtn;
    private Unbinder mUnbinder;
    private ImageBean mImageBean;
    @SuppressLint("HandlerLeak")
    private Handler mHandler1;
    private TextView mText_looper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMainPage_fragment = inflater.inflate(R.layout.main_page, container, false);
        mUnbinder = ButterKnife.bind(this, mMainPage_fragment);
        initView();
        initData();
        initListener();
        mHandler1 = new Handler();
        mHandler1.post(mLooerTask);
        return mMainPage_fragment;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mHandler1.removeCallbacks(mLooerTask);
    }

    private Runnable mLooerTask=new Runnable() {//开启子线程实现转播功能
        @Override
        public void run() {
            if (!misTouch) {
                int currentItem = LooperPager.getCurrentItem();//调用getCurrentItem()方法获取当前的item
                LooperPager.setCurrentItem(++currentItem,false);//调用此方法进行切换页面
            }
            LooperPager.postDelayed(this,3000);//重新将当前的线程传入，然后推迟3S运行，实现转播功能
        }
    };
    private void initListener() {
     mHot_jingdian_recycleview_adapter.setOnItemClickListener(new hot_jingdian_recycleview_adapter.OnItemClickListener() {
         @Override
         public void onItemClick(int position) {

         }
     });
       mHot_project_adapter.setOnclickItemListener(new hot_project_Adapter.OnclickItemListener() {
           @Override
           public void onItemClick(int position) {
              Intent intent=new Intent(mMainPage_fragment.getContext(), jingdian_item_Activity.class);
              startActivity(intent);
           }
       });

        mainSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(mMainPage_fragment.getContext(), baidu_MainActivity.class);
                startActivity(intent1);
            }
        });
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

    private void initView() {
        mText_looper = mMainPage_fragment.findViewById(R.id.text_looper);
        mLookmore = mMainPage_fragment.findViewById(R.id.look_more);
        mMainPage_goto_login = mMainPage_fragment.findViewById(R.id.mainPage_goto_login);
        LooperPager = mMainPage_fragment.findViewById(R.id.main_page_looper);
        mLooperPagerAdapter = new LooperPagerAdapter();
        mLooperPagerAdapter.setData(spics);
        LooperPager.setAdapter(mLooperPagerAdapter);
        LooperPager.addOnPageChangeListener(this);
        LooperPager.setOnViewTouchListener(this);
        LooperPager.setCurrentItem(mLooperPagerAdapter.getDataRealSize()*100,false);
       /*
       设置景点的RecycleView
        */
        mHot_jingdian_recycleView = mMainPage_fragment.findViewById(R.id.hot_jingdian_recycleView);
                        mLinearLayoutManager = new LinearLayoutManager(mMainPage_fragment.getContext(),RecyclerView.HORIZONTAL,false);
                        mHot_jingdian_recycleView.setLayoutManager(mLinearLayoutManager);//设置景点的RecycleView的展示方向和滑动的方向
                        mHot_jingdian_recycleview_adapter = new hot_jingdian_recycleview_adapter(fruitList);
                        mHot_jingdian_recycleView.addItemDecoration(new RecyclerView.ItemDecoration() {
                            @Override
                            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                                outRect.left=5;
                                outRect.right=5;
                            }
                        });
                        mHot_jingdian_recycleView.setAdapter(mHot_jingdian_recycleview_adapter);

       /*
       设置热门项目的RecycleView
       */
        mHot_jingdian_project_recycleView = mMainPage_fragment.findViewById(R.id.hot_jingdian_project);
        mHot_jingdian_project_recycleView.setLayoutManager(new LinearLayoutManager(mMainPage_fragment.getContext(),RecyclerView.HORIZONTAL,false));
        mHot_jingdian_project_recycleView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.left=5;
                outRect.right=5;
            }
        });
        mHot_project_adapter = new hot_project_Adapter(fruitList);
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

    @Override
    public void onPagerTouch(boolean isTouch) {
        misTouch=isTouch;
    }
}


