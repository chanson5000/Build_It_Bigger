package com.nverno.jokeprovider.model;

import com.google.gson.annotations.SerializedName;

public class Joke {
    @SerializedName("value")
    private String joke;

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
