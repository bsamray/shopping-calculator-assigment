package com.assignment.shopping.service;

import com.assignment.shopping.model.InventoryItem;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvStockInitialiser implements StockInitialiser {

    private String inventoryFile;

    public CsvStockInitialiser(String inventoryFileile) {
        this.inventoryFile = inventoryFileile;
    }

    /**
     * Reads inventory reference dat
     * @return List of InventoryItems
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<InventoryItem> getStock() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inventoryFile);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        return new CsvToBeanBuilder(reader)
                .withType(InventoryItem.class).withIgnoreLeadingWhiteSpace(true).build().parse();
    }

}
