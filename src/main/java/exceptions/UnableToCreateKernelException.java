package exceptions;

/**
 * Thrown if {@link kernel.KernelFactory} does not have the required parameters
 * set to create a Kernel instance.
 */
public class UnableToCreateKernelException extends IllegalStateException {
    private String message;

    public UnableToCreateKernelException(String message){
        this.message = message;
    }
}
