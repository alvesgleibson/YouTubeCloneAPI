package com.alvesgleibson.youtubeapiclone.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alvesgleibson.youtubeapiclone.R;
import com.alvesgleibson.youtubeapiclone.adapter.AdapterVideos;
import com.alvesgleibson.youtubeapiclone.model.Videos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Videos> videosLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerVideos);
        recyclerView.setHasFixedSize( true );

        //Configurar Layout
        recyclerView.setLayoutManager( new LinearLayoutManager(this));


        //Configurar o Adapter
        recuperarVideo();
        recyclerView.setAdapter( new AdapterVideos( videosLista, this ));

        //Setando a ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Youtube");
        setSupportActionBar( toolbar );

    }

    public void recuperarVideo(){

        Videos videos1 = new Videos();
        videos1.setTitulo("Ghost");


        videosLista.add( videos1 );

        Videos videos2 = new Videos();
        videos2.setTitulo("Tom e Jerre");


        videosLista.add( videos2 );

        Videos videos3 = new Videos();
        videos3.setTitulo("Vida");


        videosLista.add( videos3 );





    }

}