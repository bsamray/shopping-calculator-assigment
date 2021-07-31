package com.assignment.shopping.testutil;

import com.assignment.shopping.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestUtils {

    private static final String name = "Apples";
    private static final long price = 100;

    public static Basket buildBasket() {
        String[] purchasedItemNames = new String[] {"Apples", "Milk", "Bread"};
        Basket basket = new Basket();
        basket.populateBasket(purchasedItemNames, buildInventory());
        return basket;
    }

    public static Basket buildBasketWithNoOffers() {
        Basket basket = new Basket();
        BasketItemProps applesProps = BasketItemProps.builder()
                .quantity(2)
                .unitPrice(100)
                .discountedPercentage(0)
                .discount(0)
                .build();
        BasketItemProps milkProps = BasketItemProps.builder()
                .quantity(1)
                .unitPrice(130)
                .discountedPercentage(0)
                .discount(0)
                .build();
        BasketItemProps breadProps = BasketItemProps.builder()
                .quantity(1)
                .unitPrice(80)
                .discountedPercentage(0)
                .discount(0)
                .build();
        basket.setBasketItems(Map.of("Apples", applesProps, "Milk", milkProps, "Bread", breadProps));
        return basket;
    }

    public static Basket buildBasketWithOffersApplied() {
        Basket basket = new Basket();
        BasketItemProps applesProps = BasketItemProps.builder()
                .quantity(1)
                .unitPrice(100)
                .discountedPercentage(10)
                .discount(10)
                .build();
        BasketItemProps milkProps = BasketItemProps.builder()
                .quantity(1)
                .unitPrice(130)
                .discountedPercentage(0)
                .discount(0)
                .build();
        BasketItemProps breadProps = BasketItemProps.builder()
                .quantity(3)
                .unitPrice(80)
                .discountedPercentage(50)
                .discount(80)
                .build();
        Map<String, BasketItemProps> basketItems = new TreeMap<>();
        basketItems.put("Apples", applesProps);
        basketItems.put("Milk", milkProps);
        basketItems.put("Bread", breadProps);
        basket.setBasketItems(Map.of("Apples", applesProps, "Milk", milkProps, "Bread", breadProps));
        basket.setBasketItems(basketItems);
        return basket;
    }

    public static Inventory buildInventory() {
        InventoryItem item1 = new InventoryItem();
        item1.setName("Apples");
        item1.setUnitPrice(100);

        InventoryItem item2 = new InventoryItem();
        item2.setName("Milk");
        item2.setUnitPrice(130);

        InventoryItem item3 = new InventoryItem();
        item3.setName("Bread");
        item3.setUnitPrice(80);

        InventoryItem item4 = new InventoryItem();
        item4.setName("Soup");
        item4.setUnitPrice(65);

        Inventory inventory = new Inventory();
        inventory.setInventoryItems(List.of(item1, item2, item3, item4));
        return inventory;
    }

    public static ConsolidatedOffer buildConsolidatedOffer() {
        ItemOffer itemOffer1 = ItemOffer.builder()
                .criteriaUnits(1)
                .affectedItem("Apples")
                .affectedItemDiscountPercent(10)
                .build();
        ItemOffer itemOffer2 = ItemOffer.builder()
                .criteriaUnits(2)
                .affectedItem("Bread")
                .affectedItemDiscountPercent(50)
                .build();
        Map<String, ItemOffer> offers = new HashMap<>();
        offers.put("Apples", itemOffer1);
        offers.put("Soup", itemOffer2);

        ConsolidatedOffer consolidatedOffer = new ConsolidatedOffer();
        consolidatedOffer.setCurOffers(offers);
        return consolidatedOffer;
    }

}
