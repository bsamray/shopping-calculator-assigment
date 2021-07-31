package model;

import exception.InvalidItemInputException;
import lombok.Data;

import java.util.List;

@Data
public class Inventory {

    private List<InventoryItem> inventoryItems;

    public InventoryItem getItem(String checkItem) {
        return inventoryItems.parallelStream().filter(inventoryItem -> inventoryItem.getName().equals(checkItem))
                .findFirst()
                .orElseThrow(() -> new InvalidItemInputException("Input item ".concat(checkItem).concat(" not found")));
    }

}
