package com.razzdrawon.liniotest.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mapadi3 on 13/09/17.
 */

public class FavoritesFactory {

    public final static String BASE_URL = "http://192.168.0.2:8080/test/";

    public static FavoritesService getClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(FavoritesService.class);
    }

}
