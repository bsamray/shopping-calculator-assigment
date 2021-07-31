package model;

import exception.OfferLoadException;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ConsolidatedOffer {

    private final String DUPLICATE_ITEM_OFFER_FOUND = "Duplicate offer entry for an item detected";
    private Map<String, ItemOffer> curOffers = Map.of();

    public void consolidateOffers(List<SourcedOfferEntry> offerEntries) {
        for (SourcedOfferEntry offerEntry : offerEntries) {
            String itemName = offerEntry.getForItem();
            if (curOffers.containsKey(itemName)) {
                throw new OfferLoadException(DUPLICATE_ITEM_OFFER_FOUND);
            } else {
                ItemOffer itemOffer = ItemOffer.builder()
                        .criteriaUnits(offerEntry.getCriteriaUnits())
                        .affectedItem(offerEntry.getAffectedItem())
                        .affectedItemDiscountPercent(offerEntry.getAffectedItemDiscountPercent())
                        .build();
                curOffers.put(itemName, itemOffer);
            }
        }
    }

}
