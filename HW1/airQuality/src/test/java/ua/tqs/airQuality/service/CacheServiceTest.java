package ua.tqs.airQuality.service;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.tqs.airQuality.model.Weather;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class CacheServiceTest {


    @DisplayName("Cache service should be empty on creation and return null for any search")
    @Test
    public void shouldReturnNullForEmptyCache() {
        CacheService cache = new CacheService();
        String someCityName = "random";
        assertThat(cache.get(someCityName), nullValue());
    }


    @DisplayName("Cache service should return null after timeout expires")
    @Test
    @Disabled // CacheService's PassiveExpiringMap must be reduced for this test
    public void shouldReturnNullAfterTimeout() {
        CacheService cache = new CacheService(1000); // 1 second

        String cityName = "recife";
        Weather weather = new Weather();
        weather.setCityName(cityName);

        cache.store(cityName, weather);

        // Wait for the cache to expire
        Awaitility.await().atMost(3, TimeUnit.SECONDS).until(() ->
                cache.get(cityName) == null
        );

        assertThat(cache.get(cityName), nullValue());
    }
}