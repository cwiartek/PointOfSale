package POS.application;

public class InvalidBarcodeException extends RuntimeException {

    public InvalidBarcodeException(String message)
    {
        super(message);
    }
}
