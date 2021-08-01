package com.assignment.shopping.exception;

/**
 * Exception to handle error while loading inventory data
 */
public class InventoryLoadException extends RuntimeException {

    public InventoryLoadException(String message) {
        super(message);
    }

}
