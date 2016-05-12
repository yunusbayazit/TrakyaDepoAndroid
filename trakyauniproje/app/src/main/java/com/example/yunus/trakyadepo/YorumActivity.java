package com.example.yunus.trakyadepo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.Model.errorType;
import com.example.yunus.trakyadepo.Model.sorufilter;
import com.example.yunus.trakyadepo.Model.yorum_filter;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 12.05.2016.
 */
public class YorumActivity extends AppCompatActivity {
Context context;
    int Soru_id;
    @Bind(R.id.icerikYorum)
    EditText txtyorumicerik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yorum_activity);
        ButterKnife.bind(this);
        Soru_id =getIntent().getExtras().getInt("idd");
        context=this;

    } public boolean onCreateOptionsMenu(Menu menu) {
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

                Call<errorType> control = service.yorum_ekle(new yorum_filter(Mainapp.UserPrefs.LogedInUser().get().getUserID(), Soru_id, txtyorumicerik.getText().toString()));

                control.enqueue(new Callback<errorType>() {
                    @Override
                    public void onResponse(Response<errorType> response) {

                        Toast.makeText(context, "Yorum eklendi..", Toast.LENGTH_SHORT).show();
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
}
