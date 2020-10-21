package com.example.quanlysachphuongnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.model.HoaDons;

import java.util.List;

public class ListviewHoaDon extends BaseAdapter {

    List<HoaDons> hoaDonList;
    Context context;
    int layout;

    public ListviewHoaDon(List<HoaDons> hoaDonList, Context context, int layout) {
        this.hoaDonList = hoaDonList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return hoaDonList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lvhoadon,parent,false);
            viewHolder.textMa = convertView.findViewById(R.id.tvmahoadon);
            viewHolder.textNgay = convertView.findViewById(R.id.tvNgay);
            viewHolder.imgSua = convertView.findViewById(R.id.imgSua);
            viewHolder.imgXoa = convertView.findViewById(R.id.imgXoa);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textMa.setText(hoaDonList.get(position).getMaHoaDon());
        viewHolder.textNgay.setText(hoaDonList.get(position).getNgayMua());
        return convertView;
    }

    public class ViewHolder {
        TextView textMa,textNgay;
        ImageView imgSua,imgXoa;
    }
}
