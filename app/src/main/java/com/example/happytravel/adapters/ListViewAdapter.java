package com.example.happytravel.adapters;

import android.graphics.ImageDecoder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytravel.R;
import com.example.happytravel.bean.ItemBean;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter extends RecyclerViewBaseAdapter{

public ListViewAdapter(List<ItemBean> data){
    super(data);
}

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.jouneyphoto,null);
        return view;
    }

}





