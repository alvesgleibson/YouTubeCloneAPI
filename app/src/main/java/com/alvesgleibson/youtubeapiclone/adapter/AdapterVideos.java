package com.alvesgleibson.youtubeapiclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alvesgleibson.youtubeapiclone.R;
import com.alvesgleibson.youtubeapiclone.model.Items;
import com.alvesgleibson.youtubeapiclone.model.Videos;


import java.util.List;



public class AdapterVideos extends RecyclerView.Adapter<AdapterVideos.MyViewHolder> {

    private List<Items> videosLista;
    private Context context;

    public AdapterVideos(List<Items> videosLista, Context context) {
        this.videosLista = videosLista;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptervideos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

       Items videos = videosLista.get( position );

       //holder.capa.setImageResource(videos.getCapa());
       holder.titulo.setText(videos.snippet.title);

    }

    @Override
    public int getItemCount() {
        return videosLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        ImageView capa;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTitulo);
            capa = itemView.findViewById(R.id.imgCapa);

        }
    }
}
