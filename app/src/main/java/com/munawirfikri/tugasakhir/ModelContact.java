package com.munawirfikri.tugasakhir;

public class ModelContact {

    private int mImage;
    private String nama, email, phone, web;

    public ModelContact(int mImage, String nama, String email, String phone, String web) {
        this.mImage = mImage;
        this.nama = nama;
        this.email = email;
        this.phone = phone;
        this.web = web;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
