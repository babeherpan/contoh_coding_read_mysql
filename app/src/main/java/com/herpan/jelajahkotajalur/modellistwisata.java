package com.herpan.jelajahkotajalur;

public class modellistwisata {
    String id_wisata, nama, gambar, deskripsi, latitude, longitude;


    public modellistwisata(){};

    public modellistwisata(String id_wisata, String nama, String gambar, String deskripsi, String latitude, String longitude) {
        this.id_wisata = id_wisata;
        this.nama = nama;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
