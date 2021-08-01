package com.assignment.shopping.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OfferInitialiserTest {

    private OfferInitialiser offerInitialiser;

    @Test
    public void testPriceChartLoadsWithValidFile() {
        offerInitialiser = new CsvOfferInitialiser("offers_good.csv");

        List items = offerInitialiser.getOffers();

        assertNotNull(items);
        assertEquals(2, items.size());
    }

    @Test
    public void testPriceChartLoadErrorsWhenBadFile() {
        offerInitialiser = new CsvOfferInitialiser("offers_bad.csv");

        assertThrows(RuntimeException.class, () -> offerInitialiser.getOffers());
    }

}
