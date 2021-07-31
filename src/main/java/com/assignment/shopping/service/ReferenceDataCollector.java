package com.assignment.shopping.service;

import com.assignment.shopping.model.ConsolidatedOffer;
import com.assignment.shopping.model.Inventory;

public interface ReferenceDataCollector {

    Inventory getInventory(String source);

    ConsolidatedOffer getOffers(String source);

}
