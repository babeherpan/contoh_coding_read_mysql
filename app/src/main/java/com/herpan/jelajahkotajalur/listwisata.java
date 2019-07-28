package com.herpan.jelajahkotajalur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class listwisata extends AppCompatActivity {
    private final String JSON_url= "http://127.0.0.1/kotajalur/getdatawisata.php";
   RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RequestQueue mReques;
    List<modellistwisata> listitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listwisata);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(true);
        mReques = Volley.newRequestQueue(getApplicationContext());
        listitem = new ArrayList<>();

        request();


        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new adapterlistwisata(listitem,listwisata.this);
        mRecyclerview.setAdapter(mAdapter);


    }


    private void request(){
        JsonArrayRequest requestImage = new JsonArrayRequest(Request.Method.POST, JSON_url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse",response.toString());
                        for(int i=0; i < response.length(); i++){
                            try{
                                JSONObject data =response.getJSONObject(i);
                                modellistwisata model = new modellistwisata();
                                model.setId_wisata(data.getString("id_wisata"));
                                model.setNama(data.getString("nama"));
                                model.setGambar(data.getString("gambar"));
                                model.setDeskripsi(data.getString("deskripsi"));
                                model.setLatitude(data.getString("latitude"));
                                model.setLongitude(data.getString("longitude"));

                                listitem.add(model);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERRORRequest" , "Error: " + error.getMessage());

                    }
                });

        mReques.add(requestImage);
    }
}
