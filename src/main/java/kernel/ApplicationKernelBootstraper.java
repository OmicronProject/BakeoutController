package kernel;

import exceptions.UnableToCreateKernelException;
import kernel.controllers.VoltageController;
import kernel.serial_ports.PortDriver;
import kernel.views.VoltageReporter;

/**
 * Implements methods for bootstrapping the hardware kernel
 */
public final class ApplicationKernelBootstraper implements KernelFactory {
    private PortDriver portDriver;

    private Boolean doesKernelExist;
    private Kernel kernelInstance;

    private Boolean hasPortDriver;

    public ApplicationKernelBootstraper(){
        this.doesKernelExist = Boolean.FALSE;

        this.hasPortDriver = Boolean.FALSE;
    }

    @Override public void setPortDriver(PortDriver newPortDriver){
        this.portDriver = newPortDriver;
        this.hasPortDriver = Boolean.TRUE;
    }

    @Override public Kernel getKernelInstance() throws
            UnableToCreateKernelException {
        if (!canKernelBeStarted()){
            throw new UnableToCreateKernelException("Cannot create kernel. " +
                    "Parameter missing");
        }

        if(!doesKernelExist){
            createKernel();
        }
        return this.kernelInstance;
    }

    @Override public Boolean canKernelBeStarted(){
        if(
            !hasPortDriver
        ){
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    private void createKernel(){
        this.kernelInstance = new ApplicationKernel(
            this.portDriver
        );
        this.doesKernelExist = Boolean.TRUE;
    }

}
