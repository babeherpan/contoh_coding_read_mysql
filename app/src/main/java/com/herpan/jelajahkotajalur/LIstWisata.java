package com.herpan.jelajahkotajalur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LIstWisata extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Wisata> wisata;
    private AdapterWisata adapter;
    private Apiinterface apiInterface;

    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listwisata);

        progressBar = findViewById(R.id.progess);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        wisata = new ArrayList<>();
        adapter  = new AdapterWisata(wisata, LIstWisata.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);

        fetchWisata("");
    }

    public void fetchWisata(String key){
        apiInterface = ApiClient.getApiClient().create(Apiinterface.class);
        Call<List<Wisata>> call = apiInterface.getwisata(key);

        call.enqueue(new Callback<List<Wisata>>() {
            @Override
            public void onResponse(Call<List<Wisata>> call, Response<List<Wisata>> response) {
                progressBar.setVisibility(View.GONE);
                wisata = response.body();
                Log.e("respon dari server", "code:" +response.code()+"Jumlah wisata:"+ wisata.size());
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<List<Wisata>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LIstWisata.this,"Error on:" + t.toString(),Toast.LENGTH_SHORT).show();

            }

        });

    }
}
