package com.assignment.shopping.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ItemOffer {

    private long criteriaUnits;

    private String affectedItem;

    private double affectedItemDiscountPercent;

    public boolean isApplicable(Map.Entry<String, BasketItemProps> boughtProduct, Basket basket) {
        if ((isEnoughForOffer(boughtProduct.getValue().getQuantity())) ||
                (isDiffProductDiscount(boughtProduct.getKey()) && isDiscountedProductInBasket(affectedItem, basket))) {
            return true;
        }
        return false;
    }

    private boolean isDiscountedProductInBasket(String affectedItem, Basket basket) {
        return basket.getBasketItems().get(affectedItem) != null;
    }

    private boolean isDiffProductDiscount(String boughtProductName) {
        return !boughtProductName.equals(affectedItem);
    }

    private boolean isEnoughForOffer(long quantityBought) {
        return quantityBought >= criteriaUnits;
    }

}
