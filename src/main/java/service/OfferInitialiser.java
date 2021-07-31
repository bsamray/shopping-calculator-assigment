package service;

import model.SourcedOfferEntry;

import java.io.IOException;
import java.util.List;

public interface OfferInitialiser {

    List<SourcedOfferEntry> getOffers() throws IOException;

}
