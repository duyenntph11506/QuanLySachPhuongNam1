package com.example.quanlysachphuongnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.model.TheLoai;

import java.util.List;

public class Custom_spinner extends BaseAdapter {

    private Context context;
    private List<TheLoai> theLoaiList;

    public Custom_spinner(Context context, List<TheLoai> theLoaiList) {
        this.context = context;
        this.theLoaiList = theLoaiList;
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner, parent, false);
        TextView TenLop = view.findViewById(R.id.textViewTenTL);
        TenLop.setText(theLoaiList.get(position).getTenTheLoai());
        return view;
    }
}
