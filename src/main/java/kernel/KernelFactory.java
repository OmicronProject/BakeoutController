package kernel;

import exceptions.UnableToCreateKernelException;
import exceptions.UnableToSetParameterException;
import kernel.comm_port_manager.ICommPortManager;

/**
 * Responsible for bootstrapping the hardware kernel of the application
 */
public class KernelFactory implements IKernelFactory {
    /**
     * The name of the application
     */
    private String applicationName;

    /**
     * The current manager for serial communications
     */
    private ICommPortManager commPortManager;

    /**
     * The current kernel instance
     */
    private Kernel kernelInstance;

    /**
     * Toggles to determine if a kernel instance is running
     */
    private boolean isKernelRunning;

    /**
     * Null argument constructor
     */
    public KernelFactory(){
        this.isKernelRunning = false;
    }

    /**
     * @return The name of this application
     */
    @Override public String getApplicationName(){ return applicationName; }

    /**
     * @param newName The application name to set
     */
    @Override public void setApplicationName(String newName) throws
            UnableToSetParameterException {
        if (this.isKernelRunning) {
            throw new UnableToSetParameterException(
                "Cannot set application name for a running kernel"
            );
        }

        this.applicationName = newName;
    }

    /**
     * @return The current port manager
     */
    @Override public ICommPortManager getCommPortManager(){
        return this.commPortManager;
    }

    /**
     * @param newManager the name of the new manager
     * @throws UnableToSetParameterException if the kernel is already running
     */
    @Override public void setCommPortManager(ICommPortManager newManager)
            throws UnableToSetParameterException {
        if (this.isKernelRunning) {
            throw new UnableToSetParameterException(
                "Cannot set comm port manager for a running application"
            );
        }

        this.commPortManager = newManager;
    }

    /**
     * @return The current kernel instance
     * @throws UnableToCreateKernelException if a parameter is missing, and
     * this is preventing kernel instantiation
     */
    @Override public Kernel getKernelInstance() throws
            UnableToCreateKernelException {
        if (this.kernelInstance == null){
            this.createKernelInstance();
        }
        return this.kernelInstance;
    }

    /**
     * If the kernel doesn't exist, make it, and flip the running flag.
     *
     * @throws UnableToCreateKernelException if something is preventing
     * kernel construction
     */
    private void createKernelInstance() throws UnableToCreateKernelException {
        if (this.applicationName == null){
            throw new UnableToCreateKernelException(
                "Attempted to create an application with no name"
            );
        }
        if (this.commPortManager == null){
            throw new UnableToCreateKernelException(
                "Attempted to create an application with no serial port " +
                        "manager"
            );
        }

        this.kernelInstance = new Kernel(
            this.applicationName, this.commPortManager
        );

        this.isKernelRunning = true;
    }
}
