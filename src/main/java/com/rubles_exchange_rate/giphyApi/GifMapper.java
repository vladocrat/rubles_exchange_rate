package com.rubles_exchange_rate.giphyApi;

public class GifMapper {
    public Gif map(GifDTO dto) {
        String url = dto.getImages().getOriginal().getUrl();
        return new Gif(url);
    }

}
