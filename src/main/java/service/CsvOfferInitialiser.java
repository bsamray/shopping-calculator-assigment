package service;

import com.opencsv.bean.CsvToBeanBuilder;
import model.InventoryItem;
import model.ConsolidatedOffer;
import model.SourcedOfferEntry;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvOfferInitialiser implements OfferInitialiser {

    private static final String OFFERS_SOURCE = "src/main/resources/offers.csv";

    @Override
    @SuppressWarnings("unchecked")
    public List<SourcedOfferEntry> getOffers() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(OFFERS_SOURCE));
        return new CsvToBeanBuilder(reader)
                .withType(SourcedOfferEntry.class).withIgnoreLeadingWhiteSpace(true).build().parse();
    }

}
