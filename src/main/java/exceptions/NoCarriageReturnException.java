package exceptions;

import java.io.IOException;

/**
 * Created by mkononen on 10/01/17.
 */
public class NoCarriageReturnException extends IOException {
    public NoCarriageReturnException(String message){
        super(message);
    }
}
