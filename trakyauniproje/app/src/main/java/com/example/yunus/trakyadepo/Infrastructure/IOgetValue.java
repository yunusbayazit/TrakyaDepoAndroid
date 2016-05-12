package com.example.yunus.trakyadepo.Infrastructure;

import com.example.yunus.trakyadepo.Model.Ders;
import com.example.yunus.trakyadepo.Model.DersSecimiFilter;
import com.example.yunus.trakyadepo.Model.Gonderi;
import com.example.yunus.trakyadepo.Model.GonderiFilter;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.Yorum;
import com.example.yunus.trakyadepo.Model.errorType;
import com.example.yunus.trakyadepo.Model.modelauth;
import com.example.yunus.trakyadepo.Model.sorufilter;
import com.example.yunus.trakyadepo.Model.yorum_filter;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by yunus on 20.03.2016.
 */
public interface IOgetValue {
    @GET("Post/GetQuestion/{id}")
    Call<List<Soru>> groupList(@Path("id") int value);

    @POST("Gonderi/gonderi_ekle")
    Call<errorType> gonderi_ekle(@Body GonderiFilter gonderifilter);

    @GET("Gonderi/gonderileri_listele/{id}")
    Call<List<Gonderi>> gonderileriListele(@Path("id") int value);

    @GET("Ders/dersleri_listele/{id}")
    Call<List<Ders>> dersleri_listele(@Path("id") int userID);

    @GET("Ders/bolum_ders_listele/{id}")
    Call<List<Ders>> bolum_dersleri_listele(@Path("id") int id);

    @POST("Uye/yeniAbone")
    Call<errorType> yeni_abone(@Body DersSecimiFilter dersfilter);

    @POST("Uye/abone_sil")
    Call<errorType> abone_cıkar(@Body DersSecimiFilter dersfilter);

    @POST("Soru/Soru_Ekle")
    Call<errorType> soru_ekle(@Body sorufilter sorufilters);

    @GET("Soru/Soru_Listele/{id}")
    Call<List<Soru>> Soru_Listele(@Path("id") int id);

    @GET("Soru/Soru_Goster/{id}")
    Call<Soru> Soru_Goster(@Path("id") int id);

    @GET("Yorum/yorum_listele/{id}")
    Call<List<Yorum>> yorum_listele(@Path("id") int id);

    @POST("Yorum/yorum_ekle")
    Call<errorType> yorum_ekle(@Body yorum_filter yorumfilters);


}
