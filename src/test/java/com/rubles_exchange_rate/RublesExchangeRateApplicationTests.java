package com.rubles_exchange_rate;

import com.rubles_exchange_rate.giphyApi.repositories.GifRepository;
import com.rubles_exchange_rate.giphyApi.config.GiphyApi;
import com.rubles_exchange_rate.openexchangerateApi.config.OpenExchangeRateApi;
import com.rubles_exchange_rate.openexchangerateApi.config.OpenExchangeRateApiConfig;
import com.rubles_exchange_rate.openexchangerateApi.model.CurrencyDTO;
import com.rubles_exchange_rate.openexchangerateApi.repositories.OpenExchangeRateRepository;
import com.rubles_exchange_rate.openexchangerateApi.services.OpenExchangeRateRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RublesExchangeRateApplicationTests {
	private GiphyApi api;
	private GifRepository repository;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Test
	public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
		OpenExchangeRateApi api = Mockito.mock(OpenExchangeRateApi.class);
		OpenExchangeRateApiConfig config = new OpenExchangeRateApiConfig("localhost", "");
		OpenExchangeRateRepository localMockRepository = new OpenExchangeRateRepositoryImpl(api, config);//Mockito.mock(UserRepository.class);

		List<String> list = new ArrayList<>();
		list.add("USD");

		Map<String, Float>map = new HashMap<>();
		map.put("RUB", 1.0f);
		CurrencyDTO response = new CurrencyDTO(map);
		Mockito.when(api.getCurrencyExchangeRate("", LocalDate.now().format(formatter), "RUB", list )).thenReturn(response);

		CurrencyDTO expected = new CurrencyDTO(map);
		CurrencyDTO actual = localMockRepository.getCurrency(LocalDate.now(), "RUB", list);

		assertEquals(expected, actual);
		Mockito.verify(api).getCurrencyExchangeRate("", LocalDate.now().format(formatter), "RUB", list);
	}




	@BeforeEach
	void before() {

	}

	@AfterEach
	void after() {

	}


}
