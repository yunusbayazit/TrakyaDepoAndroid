package com.example.yunus.trakyadepo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.Soru_detail;
import com.example.yunus.trakyadepo.itemclick;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yunus on 11.05.2016.
 */
public class soruRecyclerAdapter extends  RecyclerView.Adapter<soruRecyclerViewHolder>{

private List<Soru> arrayList;
private Context context;


public soruRecyclerAdapter(Context context,
        List<Soru>arrayList){
        this.context=context;
        this.arrayList=arrayList;

        }


@Override
public int getItemCount(){
        return(null!=arrayList?arrayList.size():0);

        }

@Override
public void onBindViewHolder(final soruRecyclerViewHolder holder,
final int position){
final soruRecyclerViewHolder mainHolder=(soruRecyclerViewHolder)holder;
        //Setting text over textview
        final Context context=mainHolder.image.getContext();

        Picasso.with(context).load("http://trakyaservice.yunusbayazit.com/img/"+arrayList.get(position).getPost_Resim().toString()).placeholder(R.mipmap.ic_launcher).resize(115, 115).centerCrop().into(mainHolder.image);
        mainHolder.Ad.setText(arrayList.get(position).getKullanıcı_Adı());
        mainHolder.baslik.setText(arrayList.get(position).getSoruBaslik());
        mainHolder.Tarih.setText(arrayList.get(position).getTarih());
        mainHolder.Ders_Adı.setText(arrayList.get(position).getDers_Adı());
        mainHolder.Yorum_Sayısı.setText(arrayList.get(position).getYorum_Adedi());

        mainHolder.setClickListener(new itemclick() {
                @Override
                public void onClick(View view, int position) {
                        Intent intent = new Intent(mainHolder.context, Soru_detail.class);
                        intent.putExtra("id",arrayList.get(position).getSoruID());
                        mainHolder.context.startActivity(intent);
                }
        });
        }

@Override
public soruRecyclerViewHolder onCreateViewHolder(
        ViewGroup viewGroup,int viewType){
        LayoutInflater mInflater=LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup=(ViewGroup)mInflater.inflate(
        R.layout.soru_list,viewGroup,false);
        soruRecyclerViewHolder mainHolder=new soruRecyclerViewHolder(mainGroup){
@Override
public String toString(){
        return super.toString();
        }
        };


        return mainHolder;

        }
        }