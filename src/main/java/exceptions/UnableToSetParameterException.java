package exceptions;

/**
 * Thrown if attempting to set something that is not allowed in the current
 * application state
 */
public class UnableToSetParameterException extends IllegalStateException {
    private String message;

    public UnableToSetParameterException(String message){
        this.message = message;
    }
}
