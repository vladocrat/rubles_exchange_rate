package com.rubles_exchange_rate.giphyApi;

import com.google.gson.annotations.SerializedName;


public class GifResponse {
    @SerializedName("data")
    private GifDTO data;

    public GifDTO getData() {
        return data;
    }

    public void setData(GifDTO data) {
        this.data = data;
    }
}
