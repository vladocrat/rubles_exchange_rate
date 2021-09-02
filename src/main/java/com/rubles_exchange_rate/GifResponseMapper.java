package com.rubles_exchange_rate;

import com.google.gson.Gson;

public class GifResponseMapper {
    private Gson gson;


    GifResponse map(String json) {
       return gson.fromJson(json, GifResponse.class);
    }

    public GifResponseMapper(Gson gson) {
        this.gson = gson;
    }
}
