package ua.tqs.airQuality.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheStatisticTest {

    private CacheStatistic cacheStatistic;

    @BeforeEach
    public void setUp() {
        cacheStatistic = new CacheStatistic();
    }

    @Test
    public void shouldStartEmpty() {
        assertEquals(0, cacheStatistic.getNotFounds());
        assertEquals(0, cacheStatistic.getFounds());
        assertEquals(0, cacheStatistic.getRequests());
    }

    @Test
    public void shouldIncrementFounds() {
        cacheStatistic.addFounds();

        assertEquals(0, cacheStatistic.getNotFounds());
        assertEquals(1, cacheStatistic.getFounds());
        assertEquals(1, cacheStatistic.getRequests());
    }

    @Test
    public void shouldIncrementNotFounds() {
        cacheStatistic.addNotFounds();
        cacheStatistic.addNotFounds();

        assertEquals(2, cacheStatistic.getNotFounds());
        assertEquals(0, cacheStatistic.getFounds());
        assertEquals(2, cacheStatistic.getRequests());
    }

    @Test
    public void shouldCalculateRequests() {
        cacheStatistic.addNotFounds();
        cacheStatistic.addFounds();

        assertEquals(1, cacheStatistic.getNotFounds());
        assertEquals(1, cacheStatistic.getFounds());
        assertEquals(2, cacheStatistic.getRequests());
    }
}