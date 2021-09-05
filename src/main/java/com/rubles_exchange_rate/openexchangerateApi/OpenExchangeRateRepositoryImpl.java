package com.rubles_exchange_rate.openexchangerateApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OpenExchangeRateRepositoryImpl implements OpenExchangeRateRepository{
    private OpenExchangeRateApi api;
    private OpenExchangeRateApiConfig config;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public OpenExchangeRateRepositoryImpl(OpenExchangeRateApi api, OpenExchangeRateApiConfig config) {
        this.api = api;
        this.config = config;
    }


    @Override
    public CurrencyDTO getCurrency(LocalDate date, String base, List<String> symbols) {
        return api.getCurrencyExchangeRate(config.getApiKey(),
                date.format(formatter), base, symbols);
    }

}
