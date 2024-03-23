package com.example.clothes.model;

import java.io.Serializable;

public class LastView implements Serializable {
    private String tensp;
    private int gia;
    private int hinh;

    public LastView() {
    }

    public LastView(String tensp, int gia, int hinh) {
        this.tensp = tensp;
        this.gia = gia;
        this.hinh = hinh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}