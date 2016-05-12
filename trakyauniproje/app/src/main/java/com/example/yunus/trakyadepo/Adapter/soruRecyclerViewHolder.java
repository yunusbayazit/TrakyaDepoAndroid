package com.example.yunus.trakyadepo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.itemclick;

/**
 * Created by yunus on 11.05.2016.
 */
public class soruRecyclerViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

    TextView baslik;
    TextView Ad;
    ImageView image;
    TextView Ders_Adı;
    TextView Tarih;
    TextView Yorum_Sayısı;
    private itemclick clickListener;
    public final Context context;

    public soruRecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        context = itemView.getContext();
        this.Ad = (TextView) itemView.findViewById(R.id.soruadlbl);
        this.baslik = (TextView) itemView.findViewById(R.id.sorubasliklbl);
        this.image = (ImageView) itemView.findViewById(R.id.imagesoru);
        this.Ders_Adı=(TextView) itemView.findViewById(R.id.soruderslbl);
        this.Tarih=(TextView) itemView.findViewById(R.id.sorutarihlbl);
        this.Yorum_Sayısı=(TextView) itemView.findViewById(R.id.soruyorumlbl);

    }
    public void setClickListener(itemclick itemClickListener) {
        this.clickListener = itemClickListener;
    }
    @Override
    public void onClick(View v) {
        clickListener.onClick(v, getPosition());

    }
}