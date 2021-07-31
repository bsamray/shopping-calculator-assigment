package com.assignment.shopping.service;

import com.assignment.shopping.model.SourcedOfferEntry;

import java.io.IOException;
import java.util.List;

public interface OfferInitialiser {

    List<SourcedOfferEntry> getOffers() throws IOException;

}
