package com.assignment.shopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketItemProps {

    private long quantity;

    private long unitPrice;

    private double discountedPercentage;

    private double discount;

}
