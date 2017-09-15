package com.razzdrawon.liniotest.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.razzdrawon.liniotest.R;
import com.razzdrawon.liniotest.data.FavoritesFactory;
import com.razzdrawon.liniotest.databinding.ActivityFavoritesBinding;
import com.razzdrawon.liniotest.viewmodel.FavoritesViewModel;

import java.util.Observable;
import java.util.Observer;

public class FavoritesActivity extends AppCompatActivity implements Observer {

    private ActivityFavoritesBinding favoritesActivityBinding;
    private FavoritesViewModel favoritesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        initDataBinding();

        setupListPeopleView(favoritesActivityBinding.listProduct);
        setupObserver(favoritesViewModel);
    }

    private void initDataBinding() {
        favoritesActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_favorites);
        favoritesViewModel = new FavoritesViewModel(this);
        favoritesActivityBinding.setViewmodel(favoritesViewModel);
    }


    private void setupListPeopleView(RecyclerView listPeople) {
        ProductAdapter adapter = new ProductAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new GridLayoutManager(this, 2));
//        listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        favoritesViewModel.reset();
    }


    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof FavoritesViewModel) {
            ProductAdapter peopleAdapter = (ProductAdapter) favoritesActivityBinding.listProduct.getAdapter();
            FavoritesViewModel peopleViewModel = (FavoritesViewModel) observable;
            peopleAdapter.setPeopleList(peopleViewModel.getProductList());
        }
    }

}
