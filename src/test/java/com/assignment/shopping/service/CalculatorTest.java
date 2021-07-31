package com.assignment.shopping.service;

import com.assignment.shopping.model.Basket;
import com.assignment.shopping.testutil.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testDiscountCalculationOutputWhenNoDiscount() {
        Basket basket = TestUtils.buildBasketWithNoOffers();
        Calculator calculator = new DiscountCalculator();

        String discountInfo = calculator.getDiscountInfo(basket);

        assertEquals("Subtotal: £4.10\n(no offers available)\nTotal: £4.10", discountInfo);
    }

    @Test
    public void testDiscountCalculationOutputWhenFoundDiscount() {
        Basket basket = TestUtils.buildBasketWithOffersApplied();
        Calculator calculator = new DiscountCalculator();

        String discountInfo = calculator.getDiscountInfo(basket);

        assertEquals("Subtotal: £4.70\nApples 10% off: -10p\nBread 50% off: -80p\nTotal: £3.80", discountInfo);
    }
}
