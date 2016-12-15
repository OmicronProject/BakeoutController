package exceptions;

import kernel.ApplicationKernelFactory;

/**
 * Thrown if {@link ApplicationKernelFactory} does not have the required parameters
 * set to create a ApplicationKernel instance.
 */
public class UnableToCreateKernelException extends IllegalStateException {
    public UnableToCreateKernelException(String message){super(message);}
}
