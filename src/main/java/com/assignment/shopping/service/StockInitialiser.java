package com.assignment.shopping.service;

import com.assignment.shopping.model.InventoryItem;

import java.io.IOException;
import java.util.List;

public interface StockInitialiser {

    List<InventoryItem> getStock() throws IOException;

}
