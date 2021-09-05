package com.rubles_exchange_rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class RublesExchangeRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RublesExchangeRateApplication.class, args);
	}

}
