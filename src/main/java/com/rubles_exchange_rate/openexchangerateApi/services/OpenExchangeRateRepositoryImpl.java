package com.rubles_exchange_rate.openexchangerateApi.services;

import com.rubles_exchange_rate.openexchangerateApi.config.OpenExchangeRateApi;
import com.rubles_exchange_rate.openexchangerateApi.config.OpenExchangeRateApiConfig;
import com.rubles_exchange_rate.openexchangerateApi.model.CurrencyDTO;
import com.rubles_exchange_rate.openexchangerateApi.repositories.OpenExchangeRateRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OpenExchangeRateRepositoryImpl implements OpenExchangeRateRepository {
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
