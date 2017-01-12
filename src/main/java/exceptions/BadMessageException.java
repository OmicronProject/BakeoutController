package exceptions;

/**
 * Created by mkononen on 12/01/17.
 */
public class BadMessageException extends Exception {
    public BadMessageException(String message){
        super(message);
    }
}
