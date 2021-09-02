package com.rubles_exchange_rate;

public class GifRepositoryImpl implements GifRepository {
    private GiphyApi api;

    public GifRepositoryImpl(GiphyApi api) {
        this.api = api;
    }

    @Override
    public GifDTO getRandomGif(String tag) {
        GifResponse response = api.getRandomGif(tag);
        return  response != null ? response.getData() : null;
    }


}
