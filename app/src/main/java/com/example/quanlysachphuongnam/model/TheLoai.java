package com.example.quanlysachphuongnam.model;

public class TheLoai {
    private String ma;
    private String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(String ma, String tenTheLoai) {
        this.ma = ma;
        this.tenTheLoai = tenTheLoai;

    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }


}
