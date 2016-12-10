package exceptions;

import java.io.IOException;

/**
 * Created by mkononen on 10/12/16.
 */
public class NoAssociatedPortException extends IOException {

    public NoAssociatedPortException(String message){
        super(message);
    }
}
