package com.razzdrawon.liniotest.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.razzdrawon.liniotest.R;
import com.razzdrawon.liniotest.databinding.ItemProductBinding;
import com.razzdrawon.liniotest.model.Product;
import com.razzdrawon.liniotest.viewmodel.ItemProductViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by mapadi3 on 14/09/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>  {

    private List<Product> productList;

    public ProductAdapter() {
        this.productList = Collections.emptyList();
    }

    @Override public ProductAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductBinding itemProductBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product,
                        parent, false);
        return new ProductAdapterViewHolder(itemProductBinding);
    }

    @Override public void onBindViewHolder(ProductAdapterViewHolder holder, int position) {
        holder.bindProduct(productList.get(position));
    }

    @Override public int getItemCount() {
        return productList.size();
    }

    public void setPeopleList(List<Product> peopleList) {
        this.productList = peopleList;
        notifyDataSetChanged();
    }

    public static class ProductAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding mItemProductBinding;

        public ProductAdapterViewHolder(ItemProductBinding itemProductBinding) {
            super(itemProductBinding.itemProduct);
            this.mItemProductBinding = itemProductBinding;
        }

        void bindProduct(Product product) {
            if (mItemProductBinding.getProductViewModel() == null) {
                mItemProductBinding.setProductViewModel(
                        new ItemProductViewModel(product));
            } else {
                mItemProductBinding.getProductViewModel().setProduct(product);
            }
        }
    }
}
