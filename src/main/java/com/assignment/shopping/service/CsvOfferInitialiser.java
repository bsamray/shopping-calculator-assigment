package com.assignment.shopping.service;

import com.assignment.shopping.model.SourcedOfferEntry;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvOfferInitialiser implements OfferInitialiser {

    private String offersFilePath;

    public CsvOfferInitialiser(String offersFilePath) {
        this.offersFilePath = offersFilePath;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SourcedOfferEntry> getOffers() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(offersFilePath));
        return new CsvToBeanBuilder(reader)
                .withType(SourcedOfferEntry .class).withIgnoreLeadingWhiteSpace(true).build().parse();
    }

}
