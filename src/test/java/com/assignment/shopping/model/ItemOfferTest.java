package com.assignment.shopping.model;

import com.assignment.shopping.testutil.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemOfferTest {

    private final Basket basket = TestUtils.buildBasket();

    @Test
    public void testIsApplicableReturnsFalseWhenNotEnoughAndSameProductDiscount() {
        Map.Entry<String, BasketItemProps> basketItemPropsEntry = new AbstractMap.SimpleEntry<>("Apples",
                basket.getBasketItems().get("Apples"));
        ItemOffer itemOffer = ItemOffer.builder()
                .criteriaUnits(2)
                .affectedItem("Apples")
                .affectedItemDiscountPercent(10)
                .build();

        assertFalse(itemOffer.isApplicable(basketItemPropsEntry, basket));
    }

    @Test
    public void testIsApplicableReturnsTrueWhenEnoughAndSameProductDiscount() {
        Map.Entry<String, BasketItemProps> basketItemPropsEntry = new AbstractMap.SimpleEntry<>("Apples",
                basket.getBasketItems().get("Apples"));
        ItemOffer itemOffer = ItemOffer.builder()
                .criteriaUnits(1)
                .affectedItem("Apples")
                .affectedItemDiscountPercent(10)
                .build();

        assertTrue(itemOffer.isApplicable(basketItemPropsEntry, basket));
    }

    @Test
    public void testIsApplicableReturnsFalseWhenEnoughButOtherProductNotBought() {
        Map.Entry<String, BasketItemProps> basketItemPropsEntry = new AbstractMap.SimpleEntry<>("Apples",
                basket.getBasketItems().get("Apples"));
        ItemOffer itemOffer = ItemOffer.builder()
                .criteriaUnits(1)
                .affectedItem("CVF")
                .affectedItemDiscountPercent(10)
                .build();

        assertFalse(itemOffer.isApplicable(basketItemPropsEntry, basket));
    }

    @Test
    public void testIsApplicableReturnsTrueWhenEnoughAndOtherProductBought() {
        Map.Entry<String, BasketItemProps> basketItemPropsEntry = new AbstractMap.SimpleEntry<>("Apples",
                basket.getBasketItems().get("Apples"));
        ItemOffer itemOffer = ItemOffer.builder()
                .criteriaUnits(1)
                .affectedItem("Milk")
                .affectedItemDiscountPercent(10)
                .build();

        assertTrue(itemOffer.isApplicable(basketItemPropsEntry, basket));
    }


}
