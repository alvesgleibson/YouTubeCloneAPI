package com.alvesgleibson.youtubeapiclone.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alvesgleibson.youtubeapiclone.R;
import com.alvesgleibson.youtubeapiclone.adapter.AdapterVideos;
import com.alvesgleibson.youtubeapiclone.api.YoutubeService;
import com.alvesgleibson.youtubeapiclone.helper.RetrofitConfig;
import com.alvesgleibson.youtubeapiclone.helper.YouTubeConfig;
import com.alvesgleibson.youtubeapiclone.listener.RecyclerItemClickListener;
import com.alvesgleibson.youtubeapiclone.model.Items;
import com.alvesgleibson.youtubeapiclone.model.Resultado;
import com.alvesgleibson.youtubeapiclone.model.Videos;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Items> videosListaItem = new ArrayList<>();
    private MaterialSearchView searchView;
    private Retrofit retrofit;

    private  Resultado resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerVideos);
        searchView = findViewById(R.id.searchView);



        //Configuração Iniciais Retrofit
        retrofit = RetrofitConfig.getRetrofit();


        //Recuperar Video
        recuperarVideo();


        //Setando a ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Youtube");
        setSupportActionBar( toolbar );

        searchViewMethods();

    }


    //Metodos da Lib SeachView
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

        YoutubeService youtubeService = retrofit.create( YoutubeService.class);

        //Nova Forma
        youtubeService.recuperarVideos("snippet","date","20",
                YouTubeConfig.CHAVE_API_YOUTUBE,YouTubeConfig.CANAL_ID).enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {


                if (response.isSuccessful()){

                    resultado = response.body();
                    videosListaItem = resultado.items;
                    recuperarRecyclerView();

                }

            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

            }

        });



    }

    private void recuperarRecyclerView() {

        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter( new AdapterVideos( videosListaItem, this ));

        //Configurar evento de Clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "Clique "+position, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(MainActivity.this, "Clique no id "+i, Toast.LENGTH_SHORT).show();
                            }
                        }
                ));

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