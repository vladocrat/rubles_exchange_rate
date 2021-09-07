package com.rubles_exchange_rate.giphyApi;

import com.rubles_exchange_rate.giphyApi.models.Gif;
import com.rubles_exchange_rate.giphyApi.models.GifDTO;
import com.rubles_exchange_rate.giphyApi.repositories.GifRepository;
import com.rubles_exchange_rate.giphyApi.util.GifMapper;

public class GetRandomGifUseCase {
    private GifRepository repository;
    private GifMapper mapper = new GifMapper();

    public Gif execute(String tag) {
    GifDTO dto = repository.getRandomGif(tag);
    return mapper.map(dto);
    }

    public GetRandomGifUseCase(GifRepository repository) {
        this.repository = repository;
    }
}
