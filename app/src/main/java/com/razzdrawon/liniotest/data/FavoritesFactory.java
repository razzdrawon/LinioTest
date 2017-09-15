package com.razzdrawon.liniotest.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mapadi3 on 13/09/17.
 */

public class FavoritesFactory {

    public final static String BASE_URL = "https://gist.githubusercontent.com/la-ursic/3c5f25d5ee955ee9a6e493ac57884b9c/raw/5fab9af8e1f4db60419ba3a8da9f138cbb3a8461/Wish%2520lists/";

    public static FavoritesService getClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(FavoritesService.class);
    }

}
