package kernel;

import exceptions.UnableToCreateKernelException;
import kernel.controllers.VoltageController;
import kernel.views.VoltageReporter;

/**
 * Implements methods for bootstrapping the hardware kernel
 */
public final class ApplicationKernelBootstraper implements KernelFactory {
    private VoltageReporter voltageReporter;
    private VoltageController voltageController;
    private Boolean doesKernelExist;
    private Kernel kernelInstance;

    private Boolean hasVoltageReporter;
    private Boolean hasVoltageController;

    public ApplicationKernelBootstraper(){
        this.doesKernelExist = Boolean.FALSE;

        this.hasVoltageReporter = Boolean.FALSE;
        this.hasVoltageController = Boolean.FALSE;
    }

    @Override public void setVoltageReporter(
            VoltageReporter newVoltageReporter){
        this.voltageReporter = newVoltageReporter;
        this.hasVoltageReporter = Boolean.TRUE;
    }

    @Override public void setVoltageController(
            VoltageController newVoltageController
    ){
        this.voltageController = newVoltageController;
        this.hasVoltageController = Boolean.TRUE;
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
            !hasVoltageController || !hasVoltageReporter
        ){
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    private void createKernel(){
        this.kernelInstance = new ApplicationKernel(
            this.voltageReporter, this.voltageController
        );
        this.doesKernelExist = Boolean.TRUE;
    }

}
