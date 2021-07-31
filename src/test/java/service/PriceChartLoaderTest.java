package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PriceChartLoaderTest {

    private StockInitialiser stockInitialiser;

    @BeforeEach
    public void setup() {
        stockInitialiser = new CsvStockInitialiser();
    }

    @Test
    public void testPriceChartLoadsWithValidFile() throws IOException {
        List items = stockInitialiser.getStock();
        assertNotNull(items);
        assertEquals(4, items.size());
    }

}
