package com.example.quanlysachphuongnam.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quanlysachphuongnam.User;
import com.example.quanlysachphuongnam.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class nguoidung {
    private mysql mySql;
    SQLiteDatabase sqLiteDatabase;
    public nguoidung(mysql mySql) {
        this.mySql = mySql;
        sqLiteDatabase = mySql.getWritableDatabase();
    }

    public void themnguoidung(NguoiDung nguoiDung){
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName",nguoiDung.getName());
        contentValues.put("password",nguoiDung.getPassword());
        contentValues.put("sdt",nguoiDung.getPhoneNumber());

        sqLiteDatabase.insert("user",null,contentValues);
    }

    public List<NguoiDung> getAllUser(){
        List<NguoiDung> userList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("user",null,null,null,null,null,null);
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                String name = cursor.getString(0);
                String password = cursor.getString(1);
                String sdt = cursor.getString(2);
                byte[] img = cursor.getBlob(3);
                userList.add(new NguoiDung(name,sdt,password));
            }
            cursor.close();
        }
        return userList;
    }

}

