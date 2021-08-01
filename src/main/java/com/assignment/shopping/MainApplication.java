package com.assignment.shopping;

import com.assignment.shopping.model.Basket;
import com.assignment.shopping.model.ConsolidatedOffer;
import com.assignment.shopping.model.Inventory;
import com.assignment.shopping.service.*;

/**
 * Client class to run the application
 */
public class MainApplication {

    private static final String INVENTORY_SOURCE = "src/main/resources/inventory.csv";
    private static final String OFFER_SOURCE = "src/main/resources/inventory.csv";

    /**
     * The main method that starts the processing
     * @param args List of item names purchased
     */
    public static void main(String[] args) {
        ReferenceDataCollector collector = new ReferenceDataIntermediary();

        Inventory inventory = collector.getInventory(INVENTORY_SOURCE);
        ConsolidatedOffer offers = collector.getOffers(OFFER_SOURCE);

        Basket basket = buildInitialBasket(args, inventory);

        Basket basketWithOffersApplied = applyOffers(basket, offers);
        output(getDiscountInfo(basketWithOffersApplied));
    }

    /**
     * Builds an initial basket with unique items mapped with its properties
     * @param inputItemNames List of item names
     * @param inventory Inventory containing list of InventoryItem
     * @return Basket Returns a populated basket
     */
    private static Basket buildInitialBasket(String[] inputItemNames, Inventory inventory) {
        Basket basket = new Basket();
        basket.populateBasket(inputItemNames, inventory);
        return basket;
    }

    /**
     * Applies offers to basket
     * @param basket Initial basket without offer
     * @param consolidatedOffer unique Offers
     * @return Basket Returns a populated basket
     */
    private static Basket applyOffers(Basket basket, ConsolidatedOffer consolidatedOffer) {
        OfferHandler offerHandler = new BasketOfferApplier();
        return offerHandler.applyOffers(basket, consolidatedOffer);
    }

    /**
     * Returns discount information
     * @param basketWithOffersApplied Basket with offers applied
     * @return Text showing discount info
     */
    private static String getDiscountInfo(Basket basketWithOffersApplied) {
        Calculator calculator = new DiscountCalculator();
        return calculator.getDiscountInfo(basketWithOffersApplied);
    }

    /**
     * Passes discount string to output
     * @param info Discount info
     */
    private static void output(String info) {
        Output outputThrough = new LogOutput();
        outputThrough.output(info);
    }

}
