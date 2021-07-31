package com.assignment.shopping.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.assignment.shopping.model.InventoryItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvStockInitialiser implements StockInitialiser {

    private String inventorySource;

    public CsvStockInitialiser(String pathToFile) {
        this.inventorySource = pathToFile;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<InventoryItem> getStock() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(inventorySource));
        return new CsvToBeanBuilder(reader)
                .withType(InventoryItem.class).withIgnoreLeadingWhiteSpace(true).build().parse();
    }

}
