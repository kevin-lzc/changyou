package com.example.happytravel.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.bean.Datas;
import com.example.happytravel.adapters.ListViewAdapter;
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
            data.title="我是第"+i+"条";
            mData.add(data);
        }
        ListViewAdapter adapter=new ListViewAdapter(mData);
        mList.setAdapter(adapter);
    }

    private void initListener() {

    }

    private void initView() {

    }


}
