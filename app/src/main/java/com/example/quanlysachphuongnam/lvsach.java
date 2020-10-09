package com.example.quanlysachphuongnam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class lvsach extends BaseAdapter {
    List<ds> lvsachList;
    Context context;
    int layout;

    public lvsach(List<ds> lvsachList, Context context, int layout) {
        this.lvsachList = lvsachList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {

        return lvsachList.size();
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
        ViewHoldel viewHoldel;
        if (convertView==null){
            viewHoldel = new ViewHoldel();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout,null);
            viewHoldel.tvmasach = convertView.findViewById(R.id.tvmasach);
            viewHoldel.tvtensach = convertView.findViewById(R.id.tvtensach);
            viewHoldel.tvgia = convertView.findViewById(R.id.tvgia);
            viewHoldel.tvtheloai = convertView.findViewById(R.id.tvtheloai);
            viewHoldel.tvtacgia = convertView.findViewById(R.id.tvtacgia);
            viewHoldel.tvnxb= convertView.findViewById(R.id.tvnxb);
            viewHoldel.tvsoluong= convertView.findViewById(R.id.tvsoluong);
            viewHoldel.tvtgian = convertView.findViewById(R.id.tvtgian);
            convertView.setTag(viewHoldel);
        }
        else {
            viewHoldel = (ViewHoldel) convertView.getTag();

        }
        viewHoldel.tvmasach.setText(lvsachList.get(position).getMasach());
        viewHoldel.tvtensach.setText(lvsachList.get(position).getTensach());
        viewHoldel.tvtheloai.setText(lvsachList.get(position).getTheloai());
        viewHoldel.tvtacgia.setText(lvsachList.get(position).getTacgia());
        viewHoldel.tvnxb.setText(lvsachList.get(position).getNxb());
        viewHoldel.tvgia.setText(lvsachList.get(position).getGiasach());
        viewHoldel.tvsoluong.setText(String.valueOf(lvsachList.get(position).getSoluong()));
        viewHoldel.tvtgian.setText(lvsachList.get(position).getThoigian());

        return convertView;
    }
    public class ViewHoldel{
        TextView tvmasach, tvtensach, tvtheloai, tvgia, tvtacgia,tvnxb,tvsoluong,tvtgian;


    }
}

