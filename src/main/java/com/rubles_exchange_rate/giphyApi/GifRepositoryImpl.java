package com.rubles_exchange_rate.giphyApi;

public class GifRepositoryImpl implements GifRepository {
    private GiphyApi api;
    private GiphyApiConfig config;

    public GifRepositoryImpl(GiphyApi api, GiphyApiConfig config) {
        this.api = api;
        this.config = config;
    }

    @Override
    public GifDTO getRandomGif(String tag) {
        GifResponse response = api.getRandomGif(tag,
                config.getApiVersion(),
                config.getApiKey());
        return  response != null ? response.getData() : null;
    }


}
