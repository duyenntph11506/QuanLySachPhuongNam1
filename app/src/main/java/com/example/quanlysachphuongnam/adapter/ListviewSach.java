package com.example.quanlysachphuongnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.model.Sach;

import java.util.List;

public class ListviewSach extends BaseAdapter {
    List<Sach> sachList;
    Context context;
    int layout;

    public ListviewSach(List<Sach> sachList, Context context, int layout) {
        this.sachList = sachList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return sachList.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.lvsach,parent, false);
            viewHolder.tv1 = convertView.findViewById(R.id.tvMa);
            viewHolder.tv2 = convertView.findViewById(R.id.tvTen);
            viewHolder.tv3 = convertView.findViewById(R.id.tvTL);
            viewHolder.tv4 = convertView.findViewById(R.id.tvSL);
            viewHolder.tv5 = convertView.findViewById(R.id.tvGia);
            viewHolder.tv6 = convertView.findViewById(R.id.tvTG);
            viewHolder.tv7 = convertView.findViewById(R.id.tvNXB);
            viewHolder.tv8 = convertView.findViewById(R.id.tvTGian);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv1.setText("Mã Sách : " + sachList.get(position).getMa());
        viewHolder.tv2.setText("Tên Sách : " +sachList.get(position).getTen());
        viewHolder.tv3.setText("Giá Sách : " +String.valueOf(sachList.get(position).getGia()));
        viewHolder.tv4.setText("Thể Loại Sách : " +sachList.get(position).getTheLoai());
        viewHolder.tv5.setText("Số Lượng Sách : " +String.valueOf(sachList.get(position).getSoLuong()));
        viewHolder.tv6.setText("Tác Giả : " +sachList.get(position).getTacgia());
        viewHolder.tv7.setText("Nhà Xuất Bản : " +sachList.get(position).getNhaxuatban());
        viewHolder.tv8.setText("Ngày Nhập : " +sachList.get(position).getThoigian());

        return convertView;

    }

    public void setAdapter(ListviewSach listviewSach) {
    }


    public class ViewHolder{
        TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
        ImageView img1, img2;
    }
}
