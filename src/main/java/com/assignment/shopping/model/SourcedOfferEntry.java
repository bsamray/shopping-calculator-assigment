package com.assignment.shopping.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class SourcedOfferEntry {

    @CsvBindByPosition(position = 0, required = true)
    private String forItem;

    @CsvBindByPosition(position = 1, required = true)
    private long criteriaUnits;

    @CsvBindByPosition(position = 2, required = true)
    private String affectedItem;

    @CsvBindByPosition(position = 3, required = true)
    private double affectedItemDiscountPercent;

}
