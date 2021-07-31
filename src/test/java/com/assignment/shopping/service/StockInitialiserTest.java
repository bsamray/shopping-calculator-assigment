package com.assignment.shopping.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StockInitialiserTest {

    private StockInitialiser stockInitialiser;

    @Test
    public void testPriceChartLoadsWithValidFile() throws IOException {
        stockInitialiser = new CsvStockInitialiser("src/test/resources/inventory_good.csv");

        List items = stockInitialiser.getStock();

        assertNotNull(items);
        assertEquals(4, items.size());
    }

    @Test
    public void testPriceChartLoadErrorsWhenBadFile() throws IOException {
        stockInitialiser = new CsvStockInitialiser("src/test/resources/inventory_bad.csv");

        assertThrows(RuntimeException.class, () -> stockInitialiser.getStock());
    }

}
