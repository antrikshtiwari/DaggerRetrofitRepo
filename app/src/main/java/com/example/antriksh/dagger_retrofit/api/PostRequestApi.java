package com.example.antriksh.dagger_retrofit.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
public class PostRequestApi {

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("name")
    @Expose
    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
