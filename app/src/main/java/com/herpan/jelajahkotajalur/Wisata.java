package com.herpan.jelajahkotajalur;

import com.google.gson.annotations.SerializedName;

public class Wisata {
    @SerializedName("id_wisata") private int id_wisata;
    @SerializedName("nama") private String nama;
    @SerializedName("gambar") private String gambar;
    @SerializedName("deskripsi") private String deskripsi;
    @SerializedName("latitude") private String latitude;
    @SerializedName("longitude") private String longitude;

    public int getId_wisata() {
        return id_wisata;
    }

    public String getNama() {
        return nama;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
