package com.herpan.jelajahkotajalur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {
    @GET("getwisata.php")
    Call<List<Wisata>> getwisata (@Query("key") String keyword);
}
