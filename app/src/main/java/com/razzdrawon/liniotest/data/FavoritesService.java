package com.razzdrawon.liniotest.data;

import com.razzdrawon.liniotest.model.Favorite;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by mapadi3 on 13/09/17.
 */

public interface FavoritesService {

    @GET
    Observable<List<Favorite>> getFavorites(@Url String url);

}
