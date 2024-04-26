package com.example.btl;

public class SinhVien {
    private String masv;
    private  String tensv;
    private  String quequan;
    private  int hinh;

    public SinhVien(String masv, String tensv,String quequan, int hinh) {
        masv = masv;
        tensv = tensv;
        quequan = quequan;
        this.hinh = hinh;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String  tensv) {
        tensv = tensv;
    }
    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String  quequan) {
        quequan = quequan;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
