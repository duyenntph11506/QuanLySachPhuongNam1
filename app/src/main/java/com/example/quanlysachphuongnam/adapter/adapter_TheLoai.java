package com.example.quanlysachphuongnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.SachActivity;
import com.example.quanlysachphuongnam.model.Sach;
import com.example.quanlysachphuongnam.model.TheLoai;

import java.util.List;

//

public class adapter_TheLoai extends BaseAdapter {
    private Context context;
    private List<TheLoai> theLoaiList;

    public adapter_TheLoai(Context context, List<TheLoai> theLoaiList) {
        this.context = context;
        this.theLoaiList = theLoaiList;
    }

    public adapter_TheLoai(SachActivity context, List<Sach> sachList) {
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
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_the_loai, parent, false);
        TextView MaTL = view.findViewById(R.id.txtMaSach);
        TextView TenTL = view.findViewById(R.id.tenSach);

        MaTL.setText(theLoaiList.get(position).getMa());
        TenTL.setText(theLoaiList.get(position).getTenTheLoai());

        return view;
    }
}
