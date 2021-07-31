package com.assignment.shopping.model;

import com.assignment.shopping.exception.OfferLoadException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsolidatedOfferTest {

    @Test
    public void testConsolidateOffersThrowsErrorWhenDuplicateOfferForAnItem() {
        SourcedOfferEntry offer1 = new SourcedOfferEntry();
        offer1.setForItem("Apples");
        SourcedOfferEntry offer2 = new SourcedOfferEntry();
        offer2.setForItem("Apples");

        assertThrows(OfferLoadException.class, () ->
                new ConsolidatedOffer().consolidateOffers(List.of(offer1, offer2)));
    }

    @Test
    public void testConsolidateOffersWorks() {
        SourcedOfferEntry offer1 = new SourcedOfferEntry();
        offer1.setForItem("Apples");
        SourcedOfferEntry offer2 = new SourcedOfferEntry();
        offer2.setForItem("Bread");
        ConsolidatedOffer consolidatedOffer = new ConsolidatedOffer();

        consolidatedOffer.consolidateOffers(List.of(offer1, offer2));

        assertEquals(2, consolidatedOffer.getCurOffers().size());
        ItemOffer appleOffer = consolidatedOffer.getCurOffers().get("Apples");
        assertNotNull(appleOffer);
        ItemOffer breadOffer = consolidatedOffer.getCurOffers().get("Bread");
        assertNotNull(breadOffer);
    }

}
