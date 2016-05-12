package com.example.yunus.trakyadepo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.Yorum;
import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.Soru_detail;
import com.example.yunus.trakyadepo.itemclick;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yunus on 12.05.2016.
 */
public class yorumRecyclerAdapter extends  RecyclerView.Adapter<yorumRecyclerViewHolder>{

    private List<Yorum> arrayList;
    private Context context;


    public yorumRecyclerAdapter(Context context,
                               List<Yorum>arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }


    @Override
    public int getItemCount(){
        return(null!=arrayList?arrayList.size():0);

    }

    @Override
    public void onBindViewHolder(final yorumRecyclerViewHolder holder,
                                 final int position){
        final yorumRecyclerViewHolder mainHolder=(yorumRecyclerViewHolder)holder;
        //Setting text over textview
        final Context context=mainHolder.image.getContext();

        Picasso.with(context).load("http://trakyaservice.yunusbayazit.com/img/"+arrayList.get(position).getPost_Resim().toString()).placeholder(R.mipmap.ic_launcher).resize(115, 115).centerCrop().into(mainHolder.image);
        mainHolder.Ad.setText(arrayList.get(position).getKullanıcı_Adı());
        mainHolder.icerik.setText(arrayList.get(position).getYorum1());
        mainHolder.Tarih.setText(arrayList.get(position).getTarih());

    }

    @Override
    public yorumRecyclerViewHolder onCreateViewHolder(
            ViewGroup viewGroup,int viewType){
        LayoutInflater mInflater=LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup=(ViewGroup)mInflater.inflate(
                R.layout.soru_detail_list,viewGroup,false);
        yorumRecyclerViewHolder mainHolder=new yorumRecyclerViewHolder(mainGroup){
            @Override
            public String toString(){
                return super.toString();
            }
        };


        return mainHolder;

    }
}