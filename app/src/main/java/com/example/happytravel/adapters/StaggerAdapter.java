package com.example.happytravel.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.example.happytravel.R;
import com.example.happytravel.bean.ItemBean;

import java.util.List;

public class StaggerAdapter extends RecyclerViewBaseAdapter {
    public StaggerAdapter(List<ItemBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
       View view= View.inflate(parent.getContext(), R.layout.item_view_jouneyphoto,null);
        return view;

    }
}
