package com.rubles_exchange_rate;

import com.rubles_exchange_rate.giphyApi.GifDTO;
import com.rubles_exchange_rate.giphyApi.GifRepository;
import com.rubles_exchange_rate.giphyApi.GiphyApi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RublesExchangeRateApplicationTests {
	private GiphyApi api;
	private GifRepository repository;

	@BeforeEach
	void before() {

	}

	@AfterEach
	void after() {

	}

	@Test
	void testRandomGif() {
		GifDTO actual = repository.getRandomGif("MLP");
		GifDTO expected = new GifDTO();
		assertEquals(expected, actual);
	}

}
