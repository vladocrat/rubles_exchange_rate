package com.rubles_exchange_rate.giphyApi;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value="giphyApi")
public interface GiphyApi {

    @RequestLine("GET {version}/gifs/random?api_key={apiKey}&tag={tag}")
    GifResponse getRandomGif( @Param("tag") String tag,
                              @Param("version")String apiVersion,
                              @Param("apiKey")String apiKey);
}
