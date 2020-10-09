package com.example.quanlysachphuongnam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class lvuser extends BaseAdapter {
    List<User> userList;
    Context context;
    int layout;

    public lvuser(List<User> userList, Context context, int layout) {
        this.userList = userList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return userList.size() ;
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
        ViewHoler viewHoler;
        if (convertView==null){
            viewHoler = new ViewHoler();
            LayoutInflater inflater =LayoutInflater.from(context);
            convertView = inflater.inflate(layout,null);
            viewHoler.img = convertView.findViewById(R.id.imgUser);
            viewHoler.text = convertView.findViewById(R.id.textUser);
            convertView.setTag(viewHoler);
        }else{
            viewHoler = (ViewHoler) convertView.getTag();
        }
        viewHoler.img.setImageBitmap(userList.get(position).getAnh());
        viewHoler.text.setText(userList.get(position).getTen());
        return convertView;
    }

    public class ViewHoler{
        ImageView img;
        TextView text;
    }
}
