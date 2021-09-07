package com.rubles_exchange_rate.openexchangerateApi.repositories;

import com.rubles_exchange_rate.openexchangerateApi.model.CurrencyDTO;

import java.time.LocalDate;
import java.util.List;

public interface OpenExchangeRateRepository {
    CurrencyDTO getCurrency(LocalDate date, String base, List<String> symbols);
}
