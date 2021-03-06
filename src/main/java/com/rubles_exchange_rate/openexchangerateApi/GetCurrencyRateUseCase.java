package com.rubles_exchange_rate.openexchangerateApi;

import com.rubles_exchange_rate.openexchangerateApi.config.OpenExchangeRateApiConfig;
import com.rubles_exchange_rate.openexchangerateApi.model.Currency;
import com.rubles_exchange_rate.openexchangerateApi.model.CurrencyDTO;
import com.rubles_exchange_rate.openexchangerateApi.repositories.OpenExchangeRateRepository;
import com.rubles_exchange_rate.openexchangerateApi.util.CurrencyMapper;

import java.time.LocalDate;
import java.util.List;

public class GetCurrencyRateUseCase {
    private OpenExchangeRateRepository repository;
    private OpenExchangeRateApiConfig config;
    private CurrencyMapper mapper = new CurrencyMapper();

    public GetCurrencyRateUseCase(OpenExchangeRateRepository repository,OpenExchangeRateApiConfig config) {
        this.repository = repository;
        this.config = config;
    }

    public Currency execute(LocalDate date, String base, List<String> symbols){
        CurrencyDTO dto = repository.getCurrency(date, base, symbols);
        return mapper.map(dto, symbols);
    }
}
