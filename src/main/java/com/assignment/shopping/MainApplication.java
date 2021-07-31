package com.assignment.shopping;

import com.assignment.shopping.exception.InventoryLoadException;
import com.assignment.shopping.exception.OfferLoadException;
import com.assignment.shopping.model.Basket;
import com.assignment.shopping.model.ConsolidatedOffer;
import com.assignment.shopping.model.Inventory;
import com.assignment.shopping.service.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainApplication {

    private static final String INVENTORY_SOURCE = "src/main/resources/inventory.csv";
    private static final String OFFER_SOURCE = "src/main/resources/inventory.csv";

    public static void main(String[] args) {
        ReferenceDataCollector collector = new ReferenceDataIntermediary();

        Inventory inventory = collector.getInventory(INVENTORY_SOURCE);
        ConsolidatedOffer offers = collector.getOffers(OFFER_SOURCE);

        Basket basket = buildInitialBasket(args, inventory);

        Basket basketWithOffersApplied = applyOffers(basket, offers);
        output(getDiscountInfo(basketWithOffersApplied));
    }

    private static Basket buildInitialBasket(String[] inputItemNames, Inventory inventory) {
        Basket basket = new Basket();
        basket.populateBasket(inputItemNames, inventory);
        return basket;
    }

    private static Basket applyOffers(Basket basket, ConsolidatedOffer consolidatedOffer) {
        OfferHandler offerHandler = new BasketOfferApplier();
        return offerHandler.applyOffers(basket, consolidatedOffer);
    }

    private static String getDiscountInfo(Basket basketWithOffersApplied) {
        Calculator calculator = new DiscountCalculator();
        return calculator.getDiscountInfo(basketWithOffersApplied);
    }

    private static void output(String info) {
        Output outputThrough = new LogOutput();
        outputThrough.output(info);
    }

}
