package com.alvesgleibson.youtubeapiclone.api;

import com.alvesgleibson.youtubeapiclone.model.Resultado;


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
        &q=desenvolvimento android

        https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&maxResults=20&key=AIzaSyCxpJVunnsI7Xx_7hk-QGSGZ0R9S5A5YPg&channelId=UCFJvAGjel1N2QWyOu50pNeQ

    * */

    @GET("search")
    Call<Resultado>recuperarVideos(
            @Query("part") String part,
            @Query("order") String order,
            @Query("maxResults") String maxResults,
            @Query("key") String key,
            @Query("channelId") String channelId,
            @Query("q") String q


    );


}
