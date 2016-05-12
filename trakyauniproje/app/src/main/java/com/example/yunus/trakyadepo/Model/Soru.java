package com.example.yunus.trakyadepo.Model;

import com.google.gson.annotations.Expose;

/**
 * Created by yunus on 17.03.2016.
 */
public class Soru {

    /**
     * SoruID : 1
     * Soru1 : Ders programında herhangi bir değişiklik var mı?
     * UserID : 1
     * Tarih : 2025-11-20T00:00:00
     * SoruBaslik : Ders programında herhangi bir değişiklik var mı?
     * SoruIcerik : Herhangi bir değişiklik olucak mı olursa da bize daha önce bildirimi yapılabilirmi
     */
    @Expose
    private int SoruID;
    @Expose
    private String Soru1;
    @Expose
    private int UserID;
    @Expose
    private String Tarih;
    @Expose
    private String SoruBaslik;
    @Expose
    private String SoruIcerik;
    private String Post_Resim;
    private int DersID;

    public int getDersID() {
        return DersID;
    }

    public void setDersID(int dersID) {
        DersID = dersID;
    }

    public String getYorum_Adedi() {
        return Yorum_Adedi;
    }

    public void setYorum_Adedi(String yorum_Adedi) {
        Yorum_Adedi = yorum_Adedi;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    private String Yorum_Adedi;
    public String getPost_Resim() {
        return Post_Resim;
    }

    public void setPost_Resim(String post_Resim) {
        Post_Resim = post_Resim;
    }

    public String getKullanıcı_Adı() {
        return Kullanıcı_Adı;
    }

    public void setKullanıcı_Adı(String kullanıcı_Adı) {
        Kullanıcı_Adı = kullanıcı_Adı;
    }

    public String getDers_Adı() {
        return ders_adi;
    }

    public void setDers_Adı(String ders_Adı) {
        ders_adi = ders_Adı;
    }

    private String Kullanıcı_Adı;
    private String ders_adi;
    public int getSoruID() {
        return SoruID;
    }
    public Soru(int dersID,int User_ID,String Tarih_,String Soru_Baslik,String Soru_Icerik){
        this.UserID=User_ID;
        this.Tarih=Tarih_;
        this.SoruBaslik=Soru_Baslik;
        this.SoruIcerik=Soru_Icerik;
        this.DersID=dersID;
    }

    public void setSoruID(int SoruID) {
        this.SoruID = SoruID;
    }

    public String getSoru1() {
        return Soru1;
    }

    public void setSoru1(String Soru1) {
        this.Soru1 = Soru1;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String Tarih) {
        this.Tarih = Tarih;
    }

    public String getSoruBaslik() {
        return SoruBaslik;
    }

    public void setSoruBaslik(String SoruBaslik) {
        this.SoruBaslik = SoruBaslik;
    }

    public String getSoruIcerik() {
        return SoruIcerik;
    }

    public void setSoruIcerik(String SoruIcerik) {
        this.SoruIcerik = SoruIcerik;
    }
}
