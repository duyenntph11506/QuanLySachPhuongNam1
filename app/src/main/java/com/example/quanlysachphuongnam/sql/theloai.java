package com.example.quanlysachphuongnam.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.quanlysachphuongnam.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class theloai {
    private mysql mySql;
    SQLiteDatabase database;
    Context context;

    public theloai(Context context) {
        this.context = context;
        this.mySql = new mysql(context);
        database = mySql.getWritableDatabase();
    }

    public boolean insert(TheLoai theLoai) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenTheLoai", theLoai.getTenTheLoai());
        contentValues.put("maTheLoai", theLoai.getMa());
        long kq = database.insert("type", null, contentValues);

        if (kq > 0){
            Toast.makeText(context, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(context, "Thêm Không Thành Công", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public List<TheLoai> getData() {
        List<TheLoai> theLoaiList = new ArrayList<>();
        Cursor cursor = database.query("type", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String ten = cursor.getString(cursor.getColumnIndex("tenTheLoai"));
            String ma = cursor.getString(cursor.getColumnIndex("maTheLoai"));
            theLoaiList.add(new TheLoai(ma, ten));
        }
        cursor.close();
        return theLoaiList;
    }

    public void updateSoLuong(String maTheLoai,int soLuong) {
        ContentValues values = new ContentValues();
        values.put("soLuong", soLuong);
        database.update("type", values, "maTheLoai = ?", new String[]{String.valueOf(maTheLoai)});
    }

    public void update(TheLoai theLoai,String maTheLoai){
        ContentValues values = new ContentValues();

        values.put("tenTheLoai",theLoai.getTenTheLoai());

        database.update("type",values,"maTheLoai=?",new String[]{maTheLoai});
    }

    public void delete(String maTheLoai){
        database.delete("type","maTheLoai=?",new String[]{maTheLoai});
    }
}
