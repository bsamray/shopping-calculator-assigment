package service;

import model.Basket;
import model.ConsolidatedOffer;

public interface OfferHandler {

    Basket applyOffers(Basket basket, ConsolidatedOffer offers);

}
