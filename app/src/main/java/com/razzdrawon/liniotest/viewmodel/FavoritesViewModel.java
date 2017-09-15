package com.razzdrawon.liniotest.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.view.View;

import com.razzdrawon.liniotest.LinioTestApplication;
import com.razzdrawon.liniotest.R;
import com.razzdrawon.liniotest.data.FavoritesFactory;
import com.razzdrawon.liniotest.data.FavoritesService;
import com.razzdrawon.liniotest.model.Favorite;
import com.razzdrawon.liniotest.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by mapadi3 on 11/09/17.
 */

public class FavoritesViewModel extends Observable {


    public final ObservableList<Favorite> favoriteList = new ObservableArrayList<>();
    public final ObservableList<Product> productList = new ObservableArrayList<>();

    public final ObservableField<String> favsTitle = new ObservableField<>();
    public final ObservableField<String> messageError = new ObservableField<>();

    public ObservableInt favoritesProgress;

    private Context context;


    public FavoritesViewModel(Context context){
        this.context = context;
        favoritesProgress = new ObservableInt(View.GONE);
        updateFavorites();
    }

    public void onClickFav(View view) {
        updateFavorites();
    }


    public void updateFavorites() {
        favoriteList.clear();
        productList.clear();
        favsTitle.set("");

        favoritesProgress.set(View.VISIBLE);

        LinioTestApplication favoritesApplication = LinioTestApplication.create(context);
        FavoritesService favoritesService = favoritesApplication.getFavoritesService();

        Disposable disposable = favoritesService.getFavorites(FavoritesFactory.BASE_URL)
                .subscribeOn(favoritesApplication.subscribeScheduler())
                .subscribe(new Consumer<List<Favorite>>() {
                    @Override
                    public void accept(List<Favorite> favs) throws Exception {
                        List<Product> products = new ArrayList<Product>();
                        for(Favorite fav : favs){
                            for (Map.Entry<String, Product> entry : fav.getProductMap().entrySet())
                            {
                                products.add(entry.getValue());
                            }

                        }
                        favsTitle.set(String.format(context.getResources().getString(R.string.all_favorites), products.size()));
                        favoritesProgress.set(View.GONE);
                        changeFavoritesDataSet(favs);
                        changeProductsDataSet(products);

                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) throws Exception {
                        messageError.set(throwable.getMessage());
                        favoritesProgress.set(View.GONE);
                    }
                });
    }

    private void changeProductsDataSet(List<Product> products) {
        productList.clear();
        productList.addAll(products);
        setChanged();
        notifyObservers();
    }

    private void changeFavoritesDataSet(List<Favorite> favorites) {
        favoriteList.clear();
        favoriteList.addAll(favorites);
        setChanged();
        notifyObservers();
    }


    public ObservableList<Product> getProductList() {
        return productList;
    }

    public ObservableList<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void reset() {
        context = null;
    }
}
