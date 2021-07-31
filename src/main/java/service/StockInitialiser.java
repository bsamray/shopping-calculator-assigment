package service;

import model.InventoryItem;

import java.io.IOException;
import java.util.List;

public interface StockInitialiser {

    List<InventoryItem> getStock() throws IOException;

}
