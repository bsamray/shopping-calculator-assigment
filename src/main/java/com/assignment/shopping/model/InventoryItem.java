package com.assignment.shopping.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class InventoryItem {

    @CsvBindByPosition(position = 0, required = true)
    private String name;

    @CsvBindByPosition(position = 1, required = true)
    private long unitPrice;

}
