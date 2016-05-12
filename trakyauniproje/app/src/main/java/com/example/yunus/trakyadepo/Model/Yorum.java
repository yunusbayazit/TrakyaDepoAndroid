package com.example.yunus.trakyadepo.Model;

/**
 * Created by yunus on 12.05.2016.
 */
public class Yorum {

    /**
     * $id : 1
     * YorumID : 2
     * SoruID : 1
     * Yorum1 : deneme 8
     * Tarih : 2016-04-05T00:00:00
     * UserID : 1
     * Post_Resim : yannis.jpg
     * Kullanıcı_Adı : Yunus Emre Bayazıt
     * Soru_Tarih : 0001-01-01T00:00:00
     */


    private int YorumID;
    private int SoruID;
    private String Yorum1;
    private String Tarih;
    private int UserID;
    private String Post_Resim;
    private String Kullanıcı_Adı;
    private String Soru_Tarih;


    public int getYorumID() {
        return YorumID;
    }

    public void setYorumID(int YorumID) {
        this.YorumID = YorumID;
    }

    public int getSoruID() {
        return SoruID;
    }

    public void setSoruID(int SoruID) {
        this.SoruID = SoruID;
    }

    public String getYorum1() {
        return Yorum1;
    }

    public void setYorum1(String Yorum1) {
        this.Yorum1 = Yorum1;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String Tarih) {
        this.Tarih = Tarih;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getPost_Resim() {
        return Post_Resim;
    }

    public void setPost_Resim(String Post_Resim) {
        this.Post_Resim = Post_Resim;
    }

    public String getKullanıcı_Adı() {
        return Kullanıcı_Adı;
    }

    public void setKullanıcı_Adı(String Kullanıcı_Adı) {
        this.Kullanıcı_Adı = Kullanıcı_Adı;
    }

    public String getSoru_Tarih() {
        return Soru_Tarih;
    }

    public void setSoru_Tarih(String Soru_Tarih) {
        this.Soru_Tarih = Soru_Tarih;
    }
}
