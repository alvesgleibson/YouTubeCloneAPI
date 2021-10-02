package com.alvesgleibson.youtubeapiclone.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.alvesgleibson.youtubeapiclone.R;
import com.alvesgleibson.youtubeapiclone.adapter.AdapterVideos;
import com.alvesgleibson.youtubeapiclone.model.Videos;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Videos> videosLista = new ArrayList<>();
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerVideos);
        searchView = findViewById(R.id.searchView);

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

        searchViewMethods();

    }

    private void searchViewMethods() {
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.searchMenu);
        searchView.setMenuItem( item );
        return  true;

    }
}