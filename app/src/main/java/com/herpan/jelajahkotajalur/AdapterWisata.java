package com.herpan.jelajahkotajalur;

import android.content.Context;
import android.nfc.TagLostException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.MyViewHolder > {

    private List<Wisata> wisata;
    private Context context;

    public AdapterWisata(List<Wisata> wisata, Context context){
        this.wisata = wisata;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_wisata, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nama.setText(wisata.get(position).getNama());

        Glide.with(context).load(wisata.get(position).getGambar()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return wisata.size();
    }
    public static class  MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nama;

        public MyViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img_wisata);
            nama = (TextView) itemView.findViewById(R.id.tv_wisata);
        }
    }
}
