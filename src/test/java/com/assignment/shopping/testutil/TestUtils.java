package com.assignment.shopping.testutil;

import com.assignment.shopping.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    private static final String name = "Apples";
    private static final long price = 100;

    public static Basket buildBasket() {
        String[] purchasedItemNames = new String[] {"Apples", "Milk", "Bread"};
        Basket basket = new Basket();
        basket.populateBasket(purchasedItemNames, buildInventory());
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
