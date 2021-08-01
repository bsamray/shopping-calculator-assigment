package com.assignment.shopping.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StockInitialiserTest {

    private StockInitialiser stockInitialiser;

    @Test
    public void testPriceChartLoadsWithValidFile() {
        stockInitialiser = new CsvStockInitialiser("inventory_good.csv");

        List items = stockInitialiser.getStock();

        assertNotNull(items);
        assertEquals(4, items.size());
    }

    @Test
    public void testPriceChartLoadErrorsWhenBadFile() {
        stockInitialiser = new CsvStockInitialiser("inventory_bad.csv");

        assertThrows(RuntimeException.class, () -> stockInitialiser.getStock());
    }

}
