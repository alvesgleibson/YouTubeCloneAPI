package com.alvesgleibson.youtubeapiclone.api;

import com.alvesgleibson.youtubeapiclone.model.ResultadoYoutube;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeService {

    /*
        https://www.googleapis.com/youtube/v3/
        search
        ?part=snippet
        &order=date
        &maxResults=20
        &key=AIzaSyCxpJVunnsI7Xx_7hk-QGSGZ0R9S5A5YPg
        &channelId=UCFJvAGjel1N2QWyOu50pNeQ

        https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&maxResults=20&key=AIzaSyCxpJVunnsI7Xx_7hk-QGSGZ0R9S5A5YPg&channelId=UCFJvAGjel1N2QWyOu50pNeQ

    * */

    @GET("search")
    Call<ResultadoYoutube>recuperarVideos(
            @Query("part") String part,
            @Query("order") String order,
            @Query("maxResults") String maxResults,
            @Query("key") String key,
            @Query("channelId") String channelId


    );
}
