package com.rubles_exchange_rate.openexchangerateApi;

import java.time.LocalDate;
import java.util.List;

public interface OpenExchangeRateRepository {
    CurrencyDTO getCurrency(LocalDate date, String base, List<String> symbols);
}
