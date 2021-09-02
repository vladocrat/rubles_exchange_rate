package com.rubles_exchange_rate;

public class GifMapper {
    public Gif map(GifDTO dto) {
        String url = dto.getImages().getOriginal().getUrl();
        return new Gif(url);
    }

}
