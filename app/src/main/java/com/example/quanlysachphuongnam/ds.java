package com.example.quanlysachphuongnam;

public class ds {
    private String masach;
    private String tensach;
    private String theloai;
    private String giasach;
    private String tacgia;
    private String nxb;
    private Integer soluong;
    private String thoigian;

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getGiasach() {
        return giasach;
    }

    public void setGiasach(String giasach) {
        this.giasach = giasach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public ds(String masach, String tensach, String theloai, String giasach, String tacgia, String nxb, Integer soluong, String thoigian) {
        this.masach = masach;
        this.tensach = tensach;
        this.theloai = theloai;
        this.giasach = giasach;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.soluong = soluong;
        this.thoigian = thoigian;
    }
}
