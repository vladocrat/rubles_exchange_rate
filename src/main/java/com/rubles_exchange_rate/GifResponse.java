package com.rubles_exchange_rate;

import com.google.gson.annotations.SerializedName;

import java.util.List;



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
