package com.rubles_exchange_rate.giphyApi.models;

import com.google.gson.annotations.SerializedName;
import com.rubles_exchange_rate.giphyApi.models.GifDTO;


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
