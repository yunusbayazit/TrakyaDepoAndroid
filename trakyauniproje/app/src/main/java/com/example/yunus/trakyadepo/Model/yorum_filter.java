package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 12.05.2016.
 */
public class yorum_filter {
    private int Soru_ID;
    private String Yorum_Icerik;

    public yorum_filter( int user_ID ,int soru_ID, String yorum_Icerik) {
        Soru_ID = soru_ID;
        Yorum_Icerik = yorum_Icerik;
        User_ID = user_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    private int User_ID;


    public int getSoru_ID() {

        return Soru_ID;
    }

    public void setSoru_ID(int soru_ID) {
        Soru_ID = soru_ID;
    }

    public String getYorum_Icerik() {
        return Yorum_Icerik;
    }

    public void setYorum_Icerik(String yorum_Icerik) {
        Yorum_Icerik = yorum_Icerik;
    }
}
