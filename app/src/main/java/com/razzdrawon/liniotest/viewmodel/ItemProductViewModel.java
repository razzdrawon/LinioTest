package com.razzdrawon.liniotest.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.razzdrawon.liniotest.model.Product;

/**
 * Created by mapadi3 on 13/09/17.
 */

public class ItemProductViewModel extends BaseObservable {

    private Product product;
    private Context context;

    public ItemProductViewModel(Product product, Context context) {
        this.product = product;
        this.context = context;
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
