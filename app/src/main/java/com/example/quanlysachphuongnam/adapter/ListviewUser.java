package com.example.quanlysachphuongnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.model.NguoiDung;

import java.util.List;

public class ListviewUser extends BaseAdapter{
    List<NguoiDung> nguoiDungList;
    Context context;
    int layout;

    public ListviewUser(List<NguoiDung> nguoidunglist, Context context, int layout) {
        this.nguoiDungList = nguoidunglist;
        this.context = context;
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return nguoiDungList.size();
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
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lvnguoidung,parent,false);
            viewHolder.tv1 = convertView.findViewById(R.id.tvTen);
            viewHolder.tv2 = convertView.findViewById(R.id.tvMatKhau);
            viewHolder.tv3 = convertView.findViewById(R.id.tvEmailSĐT);
            viewHolder.img1 = convertView.findViewById(R.id.imgXoa);
            viewHolder.img2 = convertView.findViewById(R.id.imgSua);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv1.setText(nguoiDungList.get(position).getName());
        viewHolder.tv2.setText(nguoiDungList.get(position).getPassword());
        viewHolder.tv3.setText(nguoiDungList.get(position).getPhoneNumber());
        return convertView;
    }
    public class ViewHolder{
        TextView tv1, tv2, tv3;
        ImageView img1, img2;
    }
}
