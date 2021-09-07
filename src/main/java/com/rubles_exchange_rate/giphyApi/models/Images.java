package com.rubles_exchange_rate.giphyApi.models;


import com.rubles_exchange_rate.giphyApi.models.Image;

public class Images {
    private Image original;

    public Images(Image original) {
        this.original = original;
    }

    public Image getOriginal() {
        return original;
    }

    public void setOriginal(Image original) {
        this.original = original;
    }
}
