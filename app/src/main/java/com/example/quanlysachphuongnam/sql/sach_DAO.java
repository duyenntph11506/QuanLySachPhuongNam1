package com.example.quanlysachphuongnam.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class sach_DAO {
    private mysql mySql;
   public  static   SQLiteDatabase db;
    Context context;

    public sach_DAO(Context context) {
        this.context = context;
        this.mySql = new mysql(context);
        db = mySql.getWritableDatabase();
    }

    public static void setTenSach(String toString) {
    }

    public void insert(Sach sach) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSach", sach.getMa());
        contentValues.put("tenSach", sach.getTen());
        contentValues.put("soLuong", sach.getSoLuong());
        contentValues.put("gia", sach.getGia());
        contentValues.put("theLoai", sach.getTheLoai());
        contentValues.put("tacgia", sach.getTacgia());
        contentValues.put("nhaxuatban", sach.getNhaxuatban());
        contentValues.put("thoigian", sach.getThoigian());
        db.insert("book", null, contentValues);
    }

    public static List<Sach> getData() {
        List<Sach> sachList = new ArrayList<>();
        Cursor cursor = db.query("book", null, null, null, null, null, null);
        String ma;
        String ten;
        double gia;
        String theLoai;
        String nhaXuatBan;
        String tacGia;
        String thoiGian;
        int soLuong;
        while (cursor.moveToNext()) {
            ma = cursor.getString(cursor.getColumnIndex("maSach"));
            ten = cursor.getString(cursor.getColumnIndex("tenSach"));
            soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
            gia = cursor.getDouble(cursor.getColumnIndex("gia"));
            theLoai = cursor.getString(cursor.getColumnIndex("theloai"));
            tacGia = cursor.getString(cursor.getColumnIndex("tacgia"));
            nhaXuatBan = cursor.getString(cursor.getColumnIndex("nhaxuatban"));
            thoiGian = cursor.getString(cursor.getColumnIndex("thoigian"));
            sachList.add(new Sach(ten,ma,soLuong,gia,theLoai,tacGia,nhaXuatBan,thoiGian));
        }
        cursor.close();
        return sachList;
    }

    public static void delete(String maSach){
        db.delete("book","maSach=?",new String[]{maSach});
    }

    public static void update(Sach sach, String maSach){
        ContentValues values = new ContentValues();
        values.put("maSach",sach.getMa());
        values.put("tenSach",sach.getTen());
        values.put("soLuong",sach.getSoLuong());
        values.put("gia",sach.getGia());
        values.put("theloai",sach.getTheLoai());
        db.update("book",values,"maSach=?",new String[]{maSach});

    }

    public void updateTheLoai(String maSach,String theLoaiMoi){
        ContentValues values = new ContentValues();
        values.put("theloai",theLoaiMoi);
        db.update("book",values,"maSach=?",new String[]{maSach});
    }
}
