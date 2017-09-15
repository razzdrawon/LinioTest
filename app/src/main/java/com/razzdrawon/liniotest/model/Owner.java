package com.razzdrawon.liniotest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mapadi3 on 13/09/17.
 */

public class Owner implements Serializable {
    @SerializedName("name") public String name;
    @SerializedName("email") public String email;
    @SerializedName("linioId") public String linioId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinioId() {
        return linioId;
    }

    public void setLinioId(String linioId) {
        this.linioId = linioId;
    }
}
