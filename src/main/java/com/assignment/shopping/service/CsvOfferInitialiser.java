package com.assignment.shopping.service;

import com.assignment.shopping.model.SourcedOfferEntry;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvOfferInitialiser implements OfferInitialiser {

    private String offersFile;

    public CsvOfferInitialiser(String offersFile) {
        this.offersFile = offersFile;
    }

    /**
     * Reads offer reference dat
     * @return List of Offers POJO SourcedOfferEntry
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<SourcedOfferEntry> getOffers() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(offersFile);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        return new CsvToBeanBuilder(reader)
                .withType(SourcedOfferEntry .class).withIgnoreLeadingWhiteSpace(true).build().parse();
    }

}
