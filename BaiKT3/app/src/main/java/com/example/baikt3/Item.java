package com.example.baikt3;

public class Item {

    private String tenNN, mtaNN;
    private int hinh;

    public Item(String tenNN, String mtaNN, int hinh) {
        this.tenNN = tenNN;
        this.mtaNN = mtaNN;
        this.hinh = hinh;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getMtaNN() {
        return mtaNN;
    }

    public void setMtaNN(String mtaNN) {
        this.mtaNN = mtaNN;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
