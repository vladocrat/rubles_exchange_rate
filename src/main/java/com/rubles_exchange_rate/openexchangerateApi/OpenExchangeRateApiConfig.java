package com.rubles_exchange_rate.openexchangerateApi;

import java.time.LocalDate;


public class OpenExchangeRateApiConfig {
    private String endpoint;
    private String apiKey;


    public OpenExchangeRateApiConfig(String endpoint, String apiKey) {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
