package com.example.yunus.trakyadepo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yunus.trakyadepo.Adapter.soruRecyclerAdapter;
import com.example.yunus.trakyadepo.Adapter.yorumRecyclerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.Yorum;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class Soru_detail extends AppCompatActivity {
    private Soru pSoru;
    private static RecyclerView recyclerView;
    private List<Yorum> pliste= new ArrayList<>();
    @Bind(R.id.fabYorum)
    FloatingActionButton fabgonderi;
    int Soru_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Soru_id =getIntent().getExtras().getInt("id");
        ButterKnife.bind(this);

        final TextView Basliktxt= (TextView) findViewById(R.id.SoruDetailBaslik);
        final TextView Iceriktxt= (TextView) findViewById(R.id.SoruDetailIcerik);

        IOgetValue service= ws.getwsValue();
        Call<Soru> control = service.Soru_Goster(Soru_id);
        control.enqueue(new Callback<Soru>() {
            @Override
            public void onResponse(Response<Soru> response) {

                pSoru = response.body();
                Basliktxt.setText(pSoru.getSoruBaslik());
                Iceriktxt.setText(pSoru.getSoruIcerik());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        Call<List<Yorum>> control1 = service.yorum_listele(Soru_id);
        control1.enqueue(new Callback<List<Yorum>>() {
            @Override
            public void onResponse(Response<List<Yorum>> response) {

                pliste = response.body();
                setRecyclerView();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView)
                findViewById(R.id.recyclerViewSoruDetay);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(this));//Linear Items
        yorumRecyclerAdapter adapter = new yorumRecyclerAdapter(this, pliste);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }  @OnClick(R.id.fabYorum)
       public void submit(View view) {
        Intent intt = new Intent(this, YorumActivity.class);
        intt.putExtra("idd",Soru_id);
        startActivity(intt);
    }

}
