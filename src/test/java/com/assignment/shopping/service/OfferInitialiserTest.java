package com.assignment.shopping.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OfferInitialiserTest {

    private OfferInitialiser offerInitialiser;

    @Test
    public void testPriceChartLoadsWithValidFile() throws IOException {
        offerInitialiser = new CsvOfferInitialiser("src/test/resources/offers_good.csv");

        List items = offerInitialiser.getOffers();

        assertNotNull(items);
        assertEquals(2, items.size());
    }

    @Test
    public void testPriceChartLoadErrorsWhenBadFile() throws IOException {
        offerInitialiser = new CsvOfferInitialiser("src/test/resources/offers_bad.csv");

        assertThrows(RuntimeException.class, () -> offerInitialiser.getOffers());
    }

}
