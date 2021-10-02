package com.alvesgleibson.youtubeapiclone.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitConfig {

    public static Retrofit getRetrofit(String url){
        return new Retrofit.Builder().baseUrl(YouTubeConfig.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
    }


}
