package com.example.quanlysachphuongnam.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysachphuongnam.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    private mysql mySql;
    SQLiteDatabase sqLiteDatabase;
    public NguoiDungDao(mysql mySql) {
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
                userList.add(new NguoiDung(name,sdt,password));
            }
            cursor.close();
        }
        return userList;
    }

}

