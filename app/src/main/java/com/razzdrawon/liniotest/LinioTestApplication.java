package com.razzdrawon.liniotest;

import android.app.Application;
import android.content.Context;

import com.razzdrawon.liniotest.data.FavoritesFactory;
import com.razzdrawon.liniotest.data.FavoritesService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mapadi3 on 13/09/17.
 */

public class LinioTestApplication extends Application {

    private FavoritesService favoritesService;
    private Scheduler scheduler;

    private static LinioTestApplication get(Context context) {
        return (LinioTestApplication) context.getApplicationContext();
    }

    public static LinioTestApplication create(Context context) {
        return LinioTestApplication.get(context);
    }

    public FavoritesService getFavoritesService() {
        if (favoritesService == null) {
            favoritesService = FavoritesFactory.getClient();
        }

        return favoritesService;
    }

    public void setFavoritesService(FavoritesService peopleService) {
        this.favoritesService = peopleService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

}
