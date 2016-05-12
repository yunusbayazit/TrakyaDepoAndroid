package com.example.yunus.trakyadepo.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by yunus on 12.05.2016.
 */
public class sorufilter {
    @Expose
    private int User_ID;
    @Expose
    private int Ders_ID;
    @Expose
    private String SoruBaslik;
    @Expose
    private String İcerik;

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getDers_ID() {
        return Ders_ID;
    }

    public void setDers_ID(int ders_ID) {
        Ders_ID = ders_ID;
    }

    public String getSoruBaslik() {
        return SoruBaslik;
    }

    public void setSoruBaslik(String soruBaslik) {
        SoruBaslik = soruBaslik;
    }

    public String getIcerik() {
        return İcerik;
    }

    public void setIcerik(String icerik) {
        İcerik = icerik;
    }

    public sorufilter(int user_ID, int ders_ID, String soruBaslik, String icerik) {

        User_ID = user_ID;
        Ders_ID = ders_ID;
        SoruBaslik = soruBaslik;
        İcerik = icerik;
    }
}
