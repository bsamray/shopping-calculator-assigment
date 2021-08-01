package com.assignment.shopping.service;

import com.assignment.shopping.exception.InventoryLoadException;
import com.assignment.shopping.exception.OfferLoadException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReferenceDataCollectorTest {

    ReferenceDataCollector referenceDataCollector = new ReferenceDataIntermediary();

    @Test
    public void testInvalidInventoryFileLoadThrowsError() {
        assertThrows(InventoryLoadException.class, () -> referenceDataCollector
                .getInventory("inventory_bad.csv"));
    }

    @Test
    public void testValidInventoryFileLoads() {
        assertEquals(4, referenceDataCollector
                .getInventory("inventory_good.csv").getInventoryItems().size());
    }

    @Test
    public void testInvalidOfferFileLoadThrowsError() {
        assertThrows(OfferLoadException.class, () -> referenceDataCollector
                .getOffers("offers_bad.csv"));
    }

    @Test
    public void testValidOfferFileLoads() {
        assertEquals(2, referenceDataCollector
                .getOffers("offers_good.csv").getCurOffers().size());
    }

}
