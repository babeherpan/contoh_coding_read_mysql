package com.herpan.jelajahkotajalur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class adapterlistwisata extends RecyclerView.Adapter<adapterlistwisata.HolderItem> {

    List<modellistwisata> listitem ;
    Context context;

    public adapterlistwisata(List<modellistwisata> listitem, Context context) {
        this.listitem = listitem;
        this.context = context;
    }

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_wisata,parent,false);
        HolderItem holder = new HolderItem(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, int position) {
    modellistwisata mlist = listitem.get(position);

    holder.nama.setText(mlist.getNama());

    Glide.with(context).load(mlist.getGambar()).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }


    public class HolderItem extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nama;

        public HolderItem(View v){
            super(v);

            img = (ImageView) v.findViewById(R.id.img_wisata);
            nama = (TextView) v.findViewById(R.id.tv_wisata);
        }
    }
}