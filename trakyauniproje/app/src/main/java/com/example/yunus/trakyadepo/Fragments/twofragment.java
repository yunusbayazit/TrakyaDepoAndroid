package com.example.yunus.trakyadepo.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yunus.trakyadepo.Adapter.RecyclerAdapter;
import com.example.yunus.trakyadepo.Adapter.soruRecyclerAdapter;
import com.example.yunus.trakyadepo.Infrastructure.IOgetValue;
import com.example.yunus.trakyadepo.Infrastructure.Mainapp;
import com.example.yunus.trakyadepo.Infrastructure.ws;
import com.example.yunus.trakyadepo.MainActivity;
import com.example.yunus.trakyadepo.Model.Soru;
import com.example.yunus.trakyadepo.R;
import com.example.yunus.trakyadepo.etkinlikActivity;
import com.example.yunus.trakyadepo.newpostActivity;
import com.example.yunus.trakyadepo.soruActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by yunus on 11.01.2016.
 */
public class twofragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private View view;

    private String title;//String for tab title
    SwipeRefreshLayout swipeLayout;


    private ImageView image;

    private ArrayList<Soru> a;
    List<String> control;
    ProgressDialog progress;
    Context context;
    private static RecyclerView recyclerView;
    @Bind(R.id.fabSoru)
    FloatingActionButton fabgonderi;

    private List<Soru> pliste = new ArrayList<>();

    public twofragment() {
        // image.setImageResource(R.drawable.trakya);
    }

    public twofragment(String title) {
        this.title = title;//Setting tab title
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sorufragment, container, false);
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh2);
        swipeLayout.setOnRefreshListener(this);

        ButterKnife.bind(this, view);

        IOgetValue service = ws.getwsValue();
        Call<List<Soru>> control = service.Soru_Listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Soru>>() {
            @Override
            public void onResponse(Response<List<Soru>> response) {
                progress = ProgressDialog.show(getActivity(), "", "Bilgiler Alınıyor...", true);
                pliste = response.body();
                setRecyclerView();
                progress.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                progress.dismiss();
            }
        });

        return view;
    }

    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerViewSoru);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items


        soruRecyclerAdapter adapter = new soruRecyclerAdapter(getActivity(), pliste);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }


    @Override
    public void onRefresh() {
        IOgetValue service = ws.getwsValue();
        Call<List<Soru>> control = service.Soru_Listele(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Soru>>() {
            @Override
            public void onResponse(Response<List<Soru>> response) {

                pliste = response.body();
                setRecyclerView();
                swipeLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Throwable t) {
                swipeLayout.setRefreshing(false);

            }
        });
    }

    @OnClick(R.id.fabSoru)
    public void submit(View view) {
        Intent intt = new Intent(getActivity(), soruActivity.class);
        startActivity(intt);
    }

}