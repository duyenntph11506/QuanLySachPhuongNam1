package com.example.quanlysachphuongnam.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.model.HoaDons;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDao {
    private mysql mySql;
    SQLiteDatabase db;

    public HoaDonDao(mysql mySql) {
        this.mySql = mySql;
        db = mySql.getWritableDatabase();
    }

    public void insert(HoaDons hoaDon){
        ContentValues values = new ContentValues();
        values.put("maHoaDon", hoaDon.getMaHoaDon());
        values.put("ngayMua",hoaDon.getNgayMua());
        db.insert("bill",null,values);
    }

    public List<HoaDons> getData(){
        List<HoaDons> hoaDonList = new ArrayList<>();
        Cursor cursor = db.query("bill",null,null,null,null,null,null);
        if (cursor!=null){
            while (cursor.moveToNext()){
                String ma = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String date = cursor.getString(cursor.getColumnIndex("ngayMua"));
                hoaDonList.add(new HoaDons(ma,date));
            }
        }
        cursor.close();
        return hoaDonList;
    }

    public void delete(String maHoaDon){
        db.delete("bill","maHoaDon=?",new String[]{maHoaDon});
    }

    public void update(HoaDons hoaDon, String maHoaDon){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",hoaDon.getMaHoaDon());
        values.put("ngayMua",hoaDon.getNgayMua());
        db.update("bill",values,"maHoaDon=?",new String[]{maHoaDon});
    }
}
