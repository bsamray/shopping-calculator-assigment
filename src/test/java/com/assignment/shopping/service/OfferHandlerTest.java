package com.assignment.shopping.service;

import com.assignment.shopping.model.Basket;
import com.assignment.shopping.model.BasketItemProps;
import com.assignment.shopping.testutil.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OfferHandlerTest {

    @Test
    public void testNoOffersAppliedToBasket() {
        OfferHandler offerHandler = new BasketOfferApplier();
        Basket basket = offerHandler.applyOffers(TestUtils.buildBasket(), TestUtils.buildConsolidatedOffer());

        Map<String, BasketItemProps> basketItems = basket.getBasketItems();
        BasketItemProps applesItemProps = basketItems.get("Apples");
        assertNotNull(applesItemProps);
        assertEquals(1, applesItemProps.getQuantity());
        assertEquals(100, applesItemProps.getUnitPrice());
        assertEquals(10, applesItemProps.getDiscountedPercentage());
        assertEquals(10, applesItemProps.getDiscount());

        BasketItemProps soupItemProps = basketItems.get("Soup");
        assertNull(soupItemProps);

        BasketItemProps milkItemProps = basketItems.get("Milk");
        assertNotNull(milkItemProps);
        assertEquals(1, milkItemProps.getQuantity());
        assertEquals(130, milkItemProps.getUnitPrice());
        assertEquals(0, milkItemProps.getDiscountedPercentage());
        assertEquals(0, milkItemProps.getDiscount());

        BasketItemProps breadItemProps = basketItems.get("Bread");
        assertNotNull(breadItemProps);
        assertEquals(1, breadItemProps.getQuantity());
        assertEquals(80, breadItemProps.getUnitPrice());
        assertEquals(0, breadItemProps.getDiscountedPercentage());
        assertEquals(0, breadItemProps.getDiscount());
    }



}
