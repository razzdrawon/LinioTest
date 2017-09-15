package com.razzdrawon.liniotest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mapadi3 on 11/09/17.
 */

public class Favorite implements Serializable {
    @SerializedName("id") public Integer id;
    @SerializedName("name") public String name;
    @SerializedName("description") public String description;
    @SerializedName("default") public Boolean isDefault;
    @SerializedName("owner") public Owner owner;
    @SerializedName("visibility") public String visibility;
    @SerializedName("products") public Map<String, Product> productMap;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }
}
