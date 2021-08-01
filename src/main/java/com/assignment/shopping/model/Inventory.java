package com.assignment.shopping.model;

import com.assignment.shopping.exception.InvalidItemInputException;
import lombok.Data;

import java.util.List;

@Data
public class Inventory {

    private List<InventoryItem> inventoryItems;

    /**
     * Returns inventory item if present or else throws error
     * @param checkItem Item name to be checked
     * @return Inventory item
     */
    public InventoryItem getItem(String checkItem) {
        return inventoryItems.parallelStream().filter(inventoryItem -> inventoryItem.getName().equals(checkItem))
                .findFirst()
                .orElseThrow(() -> new InvalidItemInputException("Input item ".concat(checkItem).concat(" not found")));
    }

}
