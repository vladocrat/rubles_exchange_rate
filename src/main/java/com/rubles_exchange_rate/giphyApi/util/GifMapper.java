package com.rubles_exchange_rate.giphyApi.util;

import com.rubles_exchange_rate.giphyApi.models.Gif;
import com.rubles_exchange_rate.giphyApi.models.GifDTO;

public class GifMapper {
    public Gif map(GifDTO dto) {
        String url = dto.getImages().getOriginal().getUrl();
        return new Gif(url);
    }

}
