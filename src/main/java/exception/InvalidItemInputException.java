package exception;

public class InvalidItemInputException extends IllegalArgumentException{

    public InvalidItemInputException(String message) {
        super(message);
    }

}
