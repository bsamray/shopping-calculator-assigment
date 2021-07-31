package service;

import lombok.extern.slf4j.Slf4j;
import model.Basket;
import model.BasketItemProps;
import model.ConsolidatedOffer;
import model.ItemOffer;

import java.util.Map;

@Slf4j
public class BasketOfferApplier implements OfferHandler {

    @Override
    public Basket applyOffers(Basket basket, ConsolidatedOffer allOffers) {
        for (Map.Entry<String, BasketItemProps> basketItem : basket.getBasketItems().entrySet()) {

            ItemOffer itemOffer = allOffers.getCurOffers().get(basketItem.getKey());
            if (itemOffer != null && itemOffer.isApplicable(basketItem, basket)) {
                applyOffer(basket, itemOffer);
            } else {
                log.debug("No discount found for item ({})", basketItem.getKey());
            }
        }

        return basket;
    }

    private void applyOffer(Basket basket, ItemOffer itemOffer) {
        String targetOfferItem = itemOffer.getAffectedItem();
        BasketItemProps itemProps = basket.getBasketItems().get(targetOfferItem);
        itemProps.setDiscountedPercentage(itemOffer.getAffectedItemDiscountPercent());
        long unitsDiscounted = itemProps.getQuantity() / itemOffer.getCriteriaUnits();
        itemProps.setDiscount(unitsDiscounted * itemProps.getUnitPrice() *
                (itemOffer.getAffectedItemDiscountPercent()/100));
        basket.getBasketItems().put(targetOfferItem, itemProps);
    }

}
