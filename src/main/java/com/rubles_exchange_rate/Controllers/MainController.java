package com.rubles_exchange_rate.Controllers;

import com.rubles_exchange_rate.GsonDecoder;
import com.rubles_exchange_rate.giphyApi.*;
import com.rubles_exchange_rate.openexchangerateApi.*;
import feign.Feign;
import feign.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {
    private GiphyApiConfig giphyApiConfig = new GiphyApiConfig("https://api.giphy.com/",
            "XqfoKHCqG1qMCneQDCfKZN4BOvbRDY1C",
            "v1");

    private GiphyApi giphyApi = Feign.builder()
            .decoder(new GsonDecoder())
            .logLevel(Logger.Level.FULL)
            .target(GiphyApi.class, giphyApiConfig.getEndpoint());

    private GifRepository gifRepository = new GifRepositoryImpl(giphyApi, giphyApiConfig);
    private GetRandomGifUseCase getRandomGifUseCase = new GetRandomGifUseCase(gifRepository);

    private OpenExchangeRateApiConfig openExchangeRateApiConfig = new OpenExchangeRateApiConfig("https://openexchangerates.org/api/",
            "5939d2a422944252af869b8977c00ff4");

    private OpenExchangeRateApi openExchangeRateApi = Feign.builder()
            .decoder(new GsonDecoder())
            .logLevel(Logger.Level.FULL)
            .target(OpenExchangeRateApi.class, openExchangeRateApiConfig.getEndpoint());

    private OpenExchangeRateRepository openExchangeRateRepository = new OpenExchangeRateRepositoryImpl(openExchangeRateApi,
            openExchangeRateApiConfig);

    private GetCurrencyRateUseCase getCurrencyRateUseCase = new GetCurrencyRateUseCase(openExchangeRateRepository,
            openExchangeRateApiConfig);




    @GetMapping("/")
    public String index(Model model) {
        List<String> symbols = Stream.of("USD").collect(Collectors.toList());
        Currency todayRate = getCurrencyRateUseCase.execute(LocalDate.now(), "RUB", symbols);
        Currency yesterdayRate = getCurrencyRateUseCase.execute(LocalDate.now().minusDays(1), "RUB", symbols);

        Gif gif;
        if(todayRate.isLessThan(yesterdayRate)) {
            gif = getRandomGifUseCase.execute("broke");
        } else {
            gif = getRandomGifUseCase.execute("rich");
        }

        model.addAttribute("todayRate", todayRate.getRate());
        model.addAttribute("yesterdayRate", yesterdayRate.getRate());
        model.addAttribute("url", gif.getUrl());
        return "index";
    }



}
