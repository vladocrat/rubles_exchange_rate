package com.rubles_exchange_rate.openexchangerateApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CurrencyMapper {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Currency map(CurrencyDTO dto, List<String> symbols) {
        float rate = dto.getRates().get(symbols.get(0));
        return new Currency(rate);
    }
}
