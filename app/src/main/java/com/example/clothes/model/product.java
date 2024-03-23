package com.example.clothes.model;

public class product {
    private int hinh;
    private String Tensp;
    private int gia;

    public product() {
    }

    public product(int hinh, String tensp, int gia) {
        this.hinh = hinh;
        Tensp = tensp;
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
