package com.rubles_exchange_rate.Controllers;

import com.google.gson.Gson;
import com.rubles_exchange_rate.GsonDecoder;
import com.rubles_exchange_rate.giphyApi.*;
import com.rubles_exchange_rate.openexchangerateApi.OpenExchangeRateApiConfig;
import feign.Feign;
import feign.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private GiphyApiConfig config = new GiphyApiConfig("https://api.giphy.com/",
            "XqfoKHCqG1qMCneQDCfKZN4BOvbRDY1C",
            "v1");

    private GiphyApi api = Feign.builder()
            .decoder(new GsonDecoder())
            .logLevel(Logger.Level.FULL)
            .target(GiphyApi.class, config.getEndpoint());

    private GifRepository repository = new GifRepositoryImpl(api, config);
    private GetRandomGifUseCase getRandomGifUseCase = new GetRandomGifUseCase(repository);





    @GetMapping("/")
    public String index(Model model) {
        Gif gif = getRandomGifUseCase.execute("broke");
        model.addAttribute("url", gif.getUrl());
        return "index";
    }



}
