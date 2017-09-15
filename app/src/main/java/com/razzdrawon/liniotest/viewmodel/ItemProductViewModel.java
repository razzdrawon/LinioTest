package com.razzdrawon.liniotest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.razzdrawon.liniotest.model.Product;

/**
 * Created by mapadi3 on 13/09/17.
 */

public class ItemProductViewModel extends BaseObservable {

    public final ObservableBoolean isLinioPlus = new ObservableBoolean();
    public final ObservableInt isLinioPlusVisibility = new ObservableInt();
    public final ObservableBoolean isRefurbished = new ObservableBoolean();
    public final ObservableBoolean isFreeShipping = new ObservableBoolean();
    public final ObservableBoolean isImported = new ObservableBoolean();

    private Product product;

    public ItemProductViewModel(Product product) {
        this.product = product;
    }

    public ObservableBoolean getIsLinioPlus() {
        isLinioPlusVisibility.set(product.getLinioPlusLevel() > 0 ? View.VISIBLE : View.GONE);
        isLinioPlus.set(product.getLinioPlusLevel() == 1 ? true : false);
        return isLinioPlus;
    }

    public ObservableInt getIsLinioPlusVisibility() {
        return isLinioPlusVisibility;
    }

    public ObservableBoolean getIsRefurbished() {
        isRefurbished.set(product.getConditionType().equals("refurbished") ? true : false);
        return isRefurbished;
    }

    public ObservableBoolean getIsFreeShipping() {
        isFreeShipping.set(product.getFreeShipping());
        return isFreeShipping;
    }

    public ObservableBoolean getIsImported() {
        isImported.set(product.getImported());
        return isImported;
    }

    public String getImage() {
        return product.image;
    }

    public String getName(){
        return product.name;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void setProduct(Product product) {
        this.product = product;
        notifyChange();
    }

}
