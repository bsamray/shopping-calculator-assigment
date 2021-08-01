package com.assignment.shopping.exception;

/**
 * Exception to handle error while loading offer data
 */
public class OfferLoadException extends RuntimeException {

    public OfferLoadException(String message) {
        super(message);
    }

}