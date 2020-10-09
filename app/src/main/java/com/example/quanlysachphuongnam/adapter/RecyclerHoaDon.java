package com.example.quanlysachphuongnam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlysachphuongnam.R;
import com.example.quanlysachphuongnam.model.HoaDons;

import java.util.List;

public class RecyclerHoaDon extends RecyclerView.Adapter<RecyclerHoaDon.ViewHolder> {

    List<HoaDons> hoaDonList;
    Context context;
    int layout;

    public RecyclerHoaDon(List<HoaDons> hoaDonList, Context context, int layout) {
        this.hoaDonList = hoaDonList;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, parent, false);
        final ViewHolder viewHoler = new ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        HoaDons hoaDon = hoaDonList.get(position);
        holder.text1.setText(hoaDon.getMaHoaDon());
        holder.text2.setText(hoaDon.getNgayMua());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Sửa hàng  "+position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Xóa hàng "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return hoaDonList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text1,text2;
        ImageView img,imgdelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.tvmahoadon);
            text2 = itemView.findViewById(R.id.tvNgay);
            img = itemView.findViewById(R.id.imgxoa);
            imgdelete = itemView.findViewById(R.id.imgxoa);
        }
    }
}
