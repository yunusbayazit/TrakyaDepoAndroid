package com.example.yunus.trakyadepo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.itemclick;

/**
 * Created by yunus on 12.05.2016.
 */
public class yorumRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView icerik;
    TextView Ad;
    ImageView image;
    TextView Tarih;

    public final Context context;

    public yorumRecyclerViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        this.Ad = (TextView) itemView.findViewById(R.id.yorumadlbl);
        this.icerik = (TextView) itemView.findViewById(R.id.yorumiceriklbl);
        this.image = (ImageView) itemView.findViewById(R.id.imageyorum);
        this.Tarih=(TextView) itemView.findViewById(R.id.yorumtarihlbl);

    }

}