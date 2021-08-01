package com.assignment.shopping.service;

import com.assignment.shopping.exception.InventoryLoadException;
import com.assignment.shopping.exception.OfferLoadException;
import com.assignment.shopping.model.ConsolidatedOffer;
import com.assignment.shopping.model.Inventory;
import lombok.extern.slf4j.Slf4j;

public class ReferenceDataIntermediary implements ReferenceDataCollector {

    private static final String INVENTORY_LOAD_ERROR_MSG = "Error while reading inventory data";
    private static final String OFFERS_LOAD_ERROR_MSG = "Error while retrieving current offers";

    @Override
    public Inventory getInventory(String source) {
        StockInitialiser stockInitialiser = new CsvStockInitialiser(source);
        Inventory inventory = new Inventory();
        try {
            inventory.setInventoryItems(stockInitialiser.getStock());
        } catch (Exception e) {
            throw new InventoryLoadException(INVENTORY_LOAD_ERROR_MSG);
        }
        return inventory;
    }

    @Override
    public ConsolidatedOffer getOffers(String source) {
        OfferInitialiser offerInitialiser = new CsvOfferInitialiser(source);
        ConsolidatedOffer consolidatedOffer = new ConsolidatedOffer();
        try {
            consolidatedOffer.consolidateOffers(offerInitialiser.getOffers());
        } catch (Exception e) {
            throw new OfferLoadException(OFFERS_LOAD_ERROR_MSG);
        }
        return consolidatedOffer;
    }
}
