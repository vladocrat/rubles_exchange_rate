package com.rubles_exchange_rate.openexchangerateApi;


import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="openExchangeRateApi")
public interface OpenExchangeRateApi {

    @RequestLine("GET historical/{date}.json?app_id={apiKey}&base={base}&symbols={symbols}&prettyprint=1")
    CurrencyDTO getCurrencyExchangeRate(@Param("apiKey") String apiKey,
                                        @Param("date") String date,
                                        @Param("base") String base,
                                        @Param("symbols") List<String> symbols);
}
