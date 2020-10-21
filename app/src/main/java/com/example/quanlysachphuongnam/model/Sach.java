package com.example.quanlysachphuongnam.model;

public class Sach {
    private String ma;
    private String ten;
    private int soLuong;
    private double gia;
    private String theLoai;
    private String tacgia;
    private String nhaxuatban;
    private String thoigian;

    public static void setTenSach(String toString) {
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
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


    public Sach(String ma, String ten, int soLuong, double gia, String theLoai, String tacgia, String nhaxuatban, String thoigian) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
        this.theLoai = theLoai;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.thoigian = thoigian;
    }

    public Sach() {
    }
}
