package exceptions;

/**
 * Thrown if a component or method that requires a kernel does not have one
 */
public class NoKernelException extends IllegalStateException {
    public NoKernelException(String message){
        super(message);
    }
}
