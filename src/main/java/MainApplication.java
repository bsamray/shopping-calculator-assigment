import exception.InventoryLoadException;
import exception.OfferLoadException;
import lombok.extern.slf4j.Slf4j;
import model.Basket;
import model.BasketItemProps;
import model.ConsolidatedOffer;
import model.Inventory;
import service.*;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class MainApplication {

    private static final String INVENTORY_LOAD_ERROR_MSG = "Error while reading inventory data";
    private static final String OFFERS_LOAD_ERROR_MSG = "Error while retrieving current offers";
    private static final String LOWER_CURRENCY_SYMBOL = "p";
    private static final Locale locale  = Locale.getDefault();
    private static final String SEPARATE_LINE_BY = System.getProperty("LINE.SEPARATOR");

    public static void main(String[] args) {
        System.out.println("dsdsdd" + SEPARATE_LINE_BY + locale);
        Inventory inventory = getInventory();
        Basket basket = buildBasket(args, inventory);
        ConsolidatedOffer offers = getCurrentOffers();
        Basket basketWithOffersApplied = applyOffers(basket, offers);
        printOutcome(basketWithOffersApplied);
    }

    private static Inventory getInventory() {
        StockInitialiser stockInitialiser = new CsvStockInitialiser();
        Inventory inventory = new Inventory();
        try {
            inventory.setInventoryItems(stockInitialiser.getStock());
        } catch (Exception e) {
            log.error(INVENTORY_LOAD_ERROR_MSG);
            throw new InventoryLoadException(INVENTORY_LOAD_ERROR_MSG);
        }
        return inventory;
    }

    private static Basket buildBasket(String[] inputItemNames, Inventory inventory) {
        Basket basket = new Basket();
        basket.populateBasket(inputItemNames, inventory);
        return basket;
    }

    private static ConsolidatedOffer getCurrentOffers() {
        OfferInitialiser offerInitialiser = new CsvOfferInitialiser();
        ConsolidatedOffer consolidatedOffer = new ConsolidatedOffer();
        try {
            consolidatedOffer.consolidateOffers(offerInitialiser.getOffers());
        } catch (Exception e) {
            log.error(OFFERS_LOAD_ERROR_MSG);
            throw new OfferLoadException(OFFERS_LOAD_ERROR_MSG);
        }
        return consolidatedOffer;
    }

    private static Basket applyOffers(Basket basket, ConsolidatedOffer consolidatedOffer) {
        OfferHandler offerHandler = new BasketOfferApplier();
        return offerHandler.applyOffers(basket, consolidatedOffer);
    }

    private static void printOutcome(Basket basket) {
        StringBuilder sb = new StringBuilder();
        long subTotal = 0;
        double discount = 0;
        for (Map.Entry<String, BasketItemProps> product : basket.getBasketItems().entrySet()) {
            BasketItemProps itemProps = product.getValue();
            subTotal += itemProps.getQuantity() * itemProps.getUnitPrice();
            if (itemProps.getDiscount() > 0) {
                double itemDiscount = itemProps.getDiscount();
                sb.append(product.getKey())
                        .append(" ")
                        .append(itemProps.getDiscountedPercentage())
                        .append("% off: -")
                        .append(itemDiscount)
                        .append(LOWER_CURRENCY_SYMBOL)
                        .append(SEPARATE_LINE_BY);
                discount += itemDiscount;
            }
        }
        StringBuilder finalSb = new StringBuilder();
        finalSb.append("Subtotal: ")
                .append(Currency.getInstance(locale).getSymbol())
                .append(Math.round(subTotal/Math.pow(10, Currency.getInstance(locale).getDefaultFractionDigits())));
        finalSb.append(SEPARATE_LINE_BY);
        finalSb.append(sb);
        finalSb.append(SEPARATE_LINE_BY);
        finalSb.append("Total: ")
                .append(Currency.getInstance(locale).getSymbol())
                .append(Math.round((subTotal - discount)/Math.pow(10,
                        Currency.getInstance(locale).getDefaultFractionDigits())));
        log.info(finalSb.toString());
    }

}
