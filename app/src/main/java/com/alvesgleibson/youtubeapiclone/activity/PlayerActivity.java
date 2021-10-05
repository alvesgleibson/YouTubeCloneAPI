package com.alvesgleibson.youtubeapiclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.widget.Toast;

import com.alvesgleibson.youtubeapiclone.R;
import com.alvesgleibson.youtubeapiclone.helper.YouTubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private String idVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        youTubePlayerView =  findViewById(R.id.playVideo);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            idVideo = bundle.getString("idVideo");
        }



        reproduzirVideo();


    }

    private void reproduzirVideo() {
        youTubePlayerView.initialize(YouTubeConfig.CHAVE_API_YOUTUBE, this);

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.setFullscreen( true );
        youTubePlayer.setShowFullscreenButton( false);

        youTubePlayer.loadVideo(idVideo);


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Erro ao iniciar o Player "+youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
    }
}