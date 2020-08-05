package com.example.happytravel.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.happytravel.Datas;
import com.example.happytravel.adapters.ListViewAdapter;
import com.example.happytravel.adapters.StaggerAdapter;
import com.example.happytravel.bean.ItemBean;


import com.example.happytravel.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
private static final String TAG="MainActivity";
private  RecyclerView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        mList=(RecyclerView) this.findViewById(R.id.recycler_view);
        initData();
    }
    /**模拟数据*/
    private void initData(){
        List<ItemBean> mData = new ArrayList<>();

        for(int i = 0; i< Datas.icons.length; i++){
            ItemBean data=new ItemBean();
            data.icon=Datas.icons[i];
            mData.add(data);
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
      mList.setLayoutManager(layoutManager);
        ListViewAdapter adapter=new ListViewAdapter(mData);
        mList.setAdapter(adapter);
    }

    private void initListener() {

    }

    private void initView() {

    }
private void showStagger(boolean isVertical,boolean isReverse){
    List<ItemBean> mData = new ArrayList<>();
    StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,isVertical?StaggeredGridLayoutManager.VERTICAL:StaggeredGridLayoutManager.HORIZONTAL);
   layoutManager.setReverseLayout(isReverse);
   mList.setLayoutManager(layoutManager);
    StaggerAdapter adapter=new StaggerAdapter(mData);
    mList.setAdapter(adapter);
    }

}
