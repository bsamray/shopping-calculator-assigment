package com.assignment.shopping.exception;

/**
 * Exception to handle invalid items input by user
 */
public class InvalidItemInputException extends IllegalArgumentException{

    public InvalidItemInputException(String message) {
        super(message);
    }

}
