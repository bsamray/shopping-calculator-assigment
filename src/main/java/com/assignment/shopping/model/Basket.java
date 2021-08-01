package com.assignment.shopping.model;

import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

@Data
public class Basket {

    private Map<String, BasketItemProps> basketItems = new TreeMap<>();

    /**
     * Populates basket with unique items mapped to detailed item properties
     * @param itemNames List of item names
     * @param inventory Inventory for items
     */
    public void populateBasket(String[] itemNames, Inventory inventory) {
        for (String itemName : itemNames) {
            InventoryItem inventoryItem = inventory.getItem(itemName);
            if (basketItems.containsKey(itemName)) {
                long newUnits = basketItems.get(itemName).getQuantity() + 1;
                BasketItemProps itemProps = BasketItemProps.builder()
                        .quantity(newUnits)
                        .unitPrice(inventoryItem.getUnitPrice())
                        .build();
                basketItems.put(itemName, itemProps);
            } else {
                basketItems.put(itemName, BasketItemProps.builder()
                        .quantity(1)
                        .unitPrice(inventoryItem.getUnitPrice())
                        .build());
            }
        }
    }

}
