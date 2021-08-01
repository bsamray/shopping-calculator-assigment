package com.assignment.shopping.service;

import com.assignment.shopping.model.Basket;
import com.assignment.shopping.model.BasketItemProps;
import com.assignment.shopping.util.Utils;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;

public class DiscountCalculator implements Calculator {

    private static final String LOWER_CURRENCY_SYMBOL = "p";
    private static final Locale locale  = Locale.getDefault();
    private static final String SEPARATE_LINE_BY = System.lineSeparator();

    /**
     * Calculates discount and returns as text
     * @param basket
     * @return Returns Discount information
     */
    @Override
    public String getDiscountInfo(Basket basket) {
        StringBuilder sb = new StringBuilder();
        long subTotal = 0;
        double discount = 0;
        for (Map.Entry<String, BasketItemProps> product : basket.getBasketItems().entrySet()) {
            BasketItemProps itemProps = product.getValue();
            subTotal += itemProps.getQuantity() * itemProps.getUnitPrice();
            if (itemProps.getDiscount() > 0) {
                double itemDiscount = itemProps.getDiscount();
                double percentageDiscount = itemProps.getDiscountedPercentage();
                sb.append(SEPARATE_LINE_BY)
                        .append(product.getKey())
                        .append(" ")
                        .append(Utils.formatDoubleForDisplay(percentageDiscount))
                        .append("% off: -")
                        .append(Utils.formatDoubleForDisplay(itemDiscount))
                        .append(LOWER_CURRENCY_SYMBOL);
                discount += itemDiscount;
            }
        }
        StringBuilder finalSb = new StringBuilder();
        finalSb.append(SEPARATE_LINE_BY);
        finalSb.append("Subtotal: ")
                .append(Currency.getInstance(locale).getSymbol())
                .append(String.format("%.2f", subTotal/Math.pow(10, Currency.getInstance(locale).getDefaultFractionDigits())));
        finalSb.append(sb.length() > 0 ? sb : SEPARATE_LINE_BY.concat("(no offers available)"));
        finalSb.append(SEPARATE_LINE_BY);
        finalSb.append("Total: ")
                .append(Currency.getInstance(locale).getSymbol())
                .append(String.format("%.2f", (subTotal - discount)/Math.pow(10,
                        Currency.getInstance(locale).getDefaultFractionDigits())));
        return finalSb.toString();
    }

}
