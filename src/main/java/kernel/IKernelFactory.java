package kernel;

import exceptions.UnableToCreateKernelException;
import exceptions.UnableToSetParameterException;
import kernel.comm_port_manager.ICommPortManager;

/**
 * Describes methods for the kernel singleton factory. To be used by the
 * application bootloader
 */
interface IKernelFactory {
    /**
     * @return The name of the kernel
     */
    String getApplicationName();

    /**
     * @param newName The new name of the application to be set
     * @throws UnableToCreateKernelException if the application name cannot
     * be set
     */
    void setApplicationName(String newName) throws
            UnableToSetParameterException;

    /**
     * @return The current serial port manager
     */
    ICommPortManager getCommPortManager();

    /**
     * @param newManager The new manager to set
     * @throws UnableToSetParameterException if the manager cannot be set
     */
    void setCommPortManager(ICommPortManager newManager) throws
            UnableToSetParameterException;

    /**
     * @return an instance of the application kernel
     * @throws UnableToCreateKernelException if some of the parameters are
     * missing
     */
    Kernel getKernelInstance() throws UnableToCreateKernelException;
}
