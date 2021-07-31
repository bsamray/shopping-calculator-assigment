package service;

import com.opencsv.bean.CsvToBeanBuilder;
import model.InventoryItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvStockInitialiser implements StockInitialiser {

    private static final String INVENTORY_SOURCE = "src/main/resources/inventory.csv";

    @Override
    @SuppressWarnings("unchecked")
    public List<InventoryItem> getStock() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(INVENTORY_SOURCE));
        return new CsvToBeanBuilder(reader)
                .withType(InventoryItem.class).withIgnoreLeadingWhiteSpace(true).build().parse();
    }

}
