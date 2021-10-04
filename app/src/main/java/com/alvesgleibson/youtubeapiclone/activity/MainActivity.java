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

import com.alvesgleibson.youtubeapiclone.R;
import com.alvesgleibson.youtubeapiclone.adapter.AdapterVideos;
import com.alvesgleibson.youtubeapiclone.api.YoutubeService;
import com.alvesgleibson.youtubeapiclone.helper.RetrofitConfig;
import com.alvesgleibson.youtubeapiclone.helper.YouTubeConfig;
import com.alvesgleibson.youtubeapiclone.model.ResultadoYoutube;
import com.alvesgleibson.youtubeapiclone.model.Videos;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Videos> videosLista = new ArrayList<>();
    private MaterialSearchView searchView;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerVideos);
        searchView = findViewById(R.id.searchView);

        recyclerView.setHasFixedSize( true );

        //Configurar Layout
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        //Configuração Iniciais Retrofit
        retrofit = RetrofitConfig.getRetrofit();


        //Configurar o Adapter
        recuperarVideo();
        recyclerView.setAdapter( new AdapterVideos( videosLista, this ));

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

        /* Forma Antiga

        Call<ResultadoYoutube> call = youtubeService.recuperarVideos("","","","","");
        call.enqueue(new Callback<ResultadoYoutube>() {
            @Override
            public void onResponse(Call<ResultadoYoutube> call, Response<ResultadoYoutube> response) {

            }

            @Override
            public void onFailure(Call<ResultadoYoutube> call, Throwable t) {

            }
        });


        * */

        //Nova Forma
        youtubeService.recuperarVideos("snippet","date","20",
                YouTubeConfig.CHAVE_API_YOUTUBE,YouTubeConfig.CANAL_ID).enqueue(new Callback<ResultadoYoutube>() {
            @Override
            public void onResponse(Call<ResultadoYoutube> call, Response<ResultadoYoutube> response) {

                if (response.isSuccessful()){
                    if (response.code() == 200){
                        Log.d("RespostasPositiva", "RespostasPositiva: "+response.toString());
                    }else Log.d("RespostaasNegativa", "RespostasNegativa: "+response.toString());
                }



            }

            @Override
            public void onFailure(Call<ResultadoYoutube> call, Throwable t) {

            }
        });

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