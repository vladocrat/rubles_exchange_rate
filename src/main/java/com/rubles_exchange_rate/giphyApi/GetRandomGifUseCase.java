package com.rubles_exchange_rate.giphyApi;

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
