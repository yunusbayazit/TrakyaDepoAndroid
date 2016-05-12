package com.example.yunus.trakyadepo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Adapter.SpinnerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOPosts;
import com.example.yunus.trakyadepo.Infrastructure.IOauth;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.UserPrefs;
import com.example.yunus.trakyadepo.Infrastructure.userControllerfilter;
import com.example.yunus.trakyadepo.Infrastructure.ws;

import com.example.yunus.trakyadepo.Model.Ders;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.Model.errorType;
import com.example.yunus.trakyadepo.Model.modelauth;
import com.example.yunus.trakyadepo.Model.sorufilter;
import com.lacronicus.easydatastorelib.DatastoreBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 9.03.2016.
 */
public class soruActivity extends AppCompatActivity {
Context context;
    private List<Ders> dersler= new ArrayList<>();

    @Bind(R.id.spinnerderssec2)
    Spinner derssec;

    private SpinnerAdapter adapter;

    @Bind(R.id.icerikSoru)
    EditText icerikedttxt;

    @Bind(R.id.Sorubasliks)
    EditText SoruBasliktxt;


    private int secilen_ders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soruactivity);
        ButterKnife.bind(this);
        spinner_verisi();
        context=this;
        derssec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                Ders user = adapter.getItem(position);
                // Here you can do the action you want to...

                secilen_ders=user.getDersID();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.newpost, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_plus:
                // Launch settings activity
                IOgetValue service= ws.getwsValue();

                Call<errorType> control = service.soru_ekle(new sorufilter( Mainapp.UserPrefs.LogedInUser().get().getUserID(),secilen_ders, SoruBasliktxt.getText().toString(), icerikedttxt.getText().toString()));

                control.enqueue(new Callback<errorType>() {
                    @Override
                    public void onResponse(Response<errorType> response) {

                        Toast.makeText(context,"Soru eklendi..",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,MainActivity.class));
                    }
                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(context,"Bağlantı yok",Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            // more code...
        }
        return true;
    }

    private  void spinner_verisi(){
        IOgetValue service= ws.getwsValue();

        Call<List<Ders>> control = service.dersleri_listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());

        control.enqueue(new Callback<List<Ders>>() {
            @Override
            public void onResponse(Response<List<Ders>> response) {
                dersler=response.body();
                adapter = new SpinnerAdapter(getBaseContext(),
                        android.R.layout.simple_spinner_item,dersler
                );
                derssec.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

                Toast.makeText(getApplicationContext(), "Bağlantı yok", Toast.LENGTH_SHORT).show();
            }
        });



    }
}