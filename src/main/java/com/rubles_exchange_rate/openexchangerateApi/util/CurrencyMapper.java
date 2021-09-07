package com.rubles_exchange_rate.openexchangerateApi.util;

import com.rubles_exchange_rate.openexchangerateApi.model.Currency;
import com.rubles_exchange_rate.openexchangerateApi.model.CurrencyDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CurrencyMapper {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Currency map(CurrencyDTO dto, List<String> symbols) {
        float rate = dto.getRates().get(symbols.get(0));
        return new Currency(rate);
    }
}
