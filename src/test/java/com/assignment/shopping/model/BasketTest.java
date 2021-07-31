package com.assignment.shopping.model;

import com.assignment.shopping.exception.InvalidItemInputException;
import com.assignment.shopping.testutil.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void testPopulateBasketThrowsErrorUnknownItem() {
        Inventory inventory = new Inventory();
        inventory.setInventoryItems(List.of());
        Basket basket = new Basket();

        assertThrows(InvalidItemInputException.class,
                () -> basket.populateBasket(new String[] {"Apples"}, inventory));
    }

    @Test
    public void testPopulateBasketBuildsBasketItems() {
        Inventory inventory = TestUtils.buildInventory();
        Basket basket = new Basket();

        basket.populateBasket(new String[] {"Apples", "Milk", "Bread", "Apples"}, inventory);

        Map<String, BasketItemProps> basketItems = basket.getBasketItems();
        BasketItemProps applesProps = basketItems.get("Apples");
        assertEquals(2, applesProps.getQuantity());
        assertEquals(100, applesProps.getUnitPrice());
        assertEquals(0, applesProps.getDiscountedPercentage());
        assertEquals(0, applesProps.getDiscount());

        BasketItemProps milkProps = basketItems.get("Milk");
        assertEquals(1, milkProps.getQuantity());
        assertEquals(130, milkProps.getUnitPrice());
        assertEquals(0, milkProps.getDiscountedPercentage());
        assertEquals(0, milkProps.getDiscount());

        BasketItemProps breadProps = basketItems.get("Bread");
        assertEquals(1, breadProps.getQuantity());
        assertEquals(80, breadProps.getUnitPrice());
        assertEquals(0, breadProps.getDiscountedPercentage());
        assertEquals(0, breadProps.getDiscount());

        assertNull(basketItems.get("Soup"));
    }

}
