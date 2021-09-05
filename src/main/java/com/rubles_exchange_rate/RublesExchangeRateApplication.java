package com.rubles_exchange_rate;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rubles_exchange_rate.openexchangerateApi.OpenExchangeRateResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;


@SpringBootApplication
@EnableFeignClients
public class RublesExchangeRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RublesExchangeRateApplication.class, args);
	}

}
