package com.rubles_exchange_rate.openexchangerateApi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;

public class CurrencyDTO {
    @SerializedName("rates")
    private Map<String, Float> rates;

    public CurrencyDTO(Map<String, Float> rates) {
        this.rates = rates;
    }

    public Map<String, Float> getRates() {
        return rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyDTO that = (CurrencyDTO) o;
        return Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates);
    }
}
