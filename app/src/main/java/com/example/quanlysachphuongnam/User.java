package com.example.quanlysachphuongnam;

import android.graphics.Bitmap;

public class User {
    private Bitmap anh;
    private  String ten;

    public Bitmap getAnh() {
        return anh;
    }

    public void setAnh(Bitmap anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public User(Bitmap anh, String ten) {
        this.anh = anh;
        this.ten = ten;
    }
}
