package com.assignment.shopping.service;

import com.assignment.shopping.model.Basket;
import com.assignment.shopping.model.ConsolidatedOffer;

public interface OfferHandler {

    Basket applyOffers(Basket basket, ConsolidatedOffer offers);

}
