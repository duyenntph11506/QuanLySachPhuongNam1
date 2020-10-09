package com.example.quanlysachphuongnam.model;

public class Sach {
    private String ten;
    private String ma;
    private int soLuong;
    private String gia;
    private String theLoai;
    private String tacgia;
    private String nhaxuatban;
    private String thoigian;

    public Sach(String ten, String ma, int soLuong, String gia) {
    }

    public Sach(String ten, String ma, int soLuong, String gia, String theLoai) {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public Sach(String ten, String ma, int soLuong, String gia, String theLoai, String tacgia, String nhaxuatban, String thoigian) {
        this.ten = ten;
        this.ma = ma;
        this.soLuong = soLuong;
        this.gia = gia;
        this.theLoai = theLoai;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.thoigian = thoigian;
    }
}
