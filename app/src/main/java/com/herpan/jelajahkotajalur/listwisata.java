package com.herpan.jelajahkotajalur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listwisata extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager LayoutManager;
    private List<Wisata> wisata;
    private Adapter adapter;
    private Apiinterface apiinterface;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listwisata);

        progressBar = findViewById(R.id.progess);
        recyclerView = findViewById(R.id.recyclerview);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setHasFixedSize(true);

        fetchWisata("");
    }

    public void fetchWisata(String key){
        apiinterface = ApiClient.getApiClient().create(Apiinterface.class);
        Call<List<Wisata>> call = apiinterface.getWisata(key);

        call.enqueue(new Callback<List<Wisata>>() {
            @Override
            public void onResponse(Call<List<Wisata>> call, Response<List<Wisata>> response) {
                progressBar.setVisibility(View.GONE);
                wisata = response.body();
                adapter = (Adapter) new AdapterWisata(wisata,listwisata.this);
                recyclerView.setAdapter((RecyclerView.Adapter) adapter);
                ((RecyclerView.Adapter) adapter).notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Wisata>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(listwisata.this,"Error on:" + t.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
