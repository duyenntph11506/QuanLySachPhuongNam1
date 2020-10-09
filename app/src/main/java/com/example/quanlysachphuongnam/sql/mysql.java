package com.example.quanlysachphuongnam.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mysql extends SQLiteOpenHelper {
    Context context;
    @Override
    public void onCreate(SQLiteDatabase db) {
            String table_user = "CREATE TABLE user (userName TEXT primary key, password TEXT NOT NULL, sdt TEXT NOT NULL)";
            String table_sach = "CREATE TABLE book (maSach TEXT primary key, tenSach TEXT NOT NULL, soLuong INTEGER, gia FLOAT NOT NULL, theloai TEXT NOT NULL, tacgia TEXT NOT NULL, nhaxuatban TEXT NOT NULL)";
            String table_the_loai = "CREATE TABLE type (maTheLoai TEXT primary key, tenTheLoai TEXT, soLuong TEXT)";
            String table_hoa_don = "CREATE TABLE bill (maHoaDon TEXT primary key, ngayMua DATE NOT NULL )";
            String table_hoa_don_chi_tiet = "CREATE TABLE billDetail (maHDCT INTEGER  PRIMARY KEY AUTOINCREMENT,  maHoaDon TEXT, maSach TEXT, soLuongMua INTERGER)";
            db.execSQL(table_user);
            db.execSQL(table_sach);
            db.execSQL(table_the_loai);
            db.execSQL(table_hoa_don);
            db.execSQL(table_hoa_don_chi_tiet);
        }

    public mysql(@Nullable Context context) {
        super(context, "data.sql", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
