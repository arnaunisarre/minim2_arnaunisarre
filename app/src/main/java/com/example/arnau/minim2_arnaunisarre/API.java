package com.example.arnau.minim2_arnaunisarre;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class API {

    private static API instance;

    private static final String baseUrl = "http://api.dsamola.tk";
    public static APIInterface api;

    private API(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(APIInterface.class);
    };

    public static API getInstance(){
        if(instance==null)
            return new API();
        return instance;
    }

}
