package com.rubles_exchange_rate.giphyApi.repositories;

import com.rubles_exchange_rate.giphyApi.models.GifDTO;

public interface GifRepository {
    GifDTO getRandomGif(String tag);
}
