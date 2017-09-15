package com.razzdrawon.liniotest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mapadi3 on 11/09/17.
 */

public class Product implements Serializable {

    @SerializedName("id") public Integer id;
    @SerializedName("name") public String name;
    @SerializedName("wishListPrice") public Integer wishListPrice;
    @SerializedName("slug") public String slug;
    @SerializedName("url") public String url;
    @SerializedName("image") public String image;
    @SerializedName("linioPlusLevel") public Integer linioPlusLevel;
    @SerializedName("conditionType") public String conditionType;
    @SerializedName("freeShipping") public Boolean freeShipping;
    @SerializedName("imported") public Boolean imported;
    @SerializedName("active") public Boolean active;

    public String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWishListPrice() {
        return wishListPrice;
    }

    public void setWishListPrice(Integer wishListPrice) {
        this.wishListPrice = wishListPrice;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLinioPlusLevel() {
        return linioPlusLevel;
    }

    public void setLinioPlusLevel(Integer linioPlusLevel) {
        this.linioPlusLevel = linioPlusLevel;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
