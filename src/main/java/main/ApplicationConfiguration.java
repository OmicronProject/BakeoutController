package main;

import kernel.ApplicationKernelBootstraper;
import kernel.Kernel;
import kernel.KernelFactory;
import kernel.serial_ports.PortDriver;
import kernel.serial_ports.RXTXPortDriver;
import kernel.serial_ports.comm_port_wrapper.JavaCommsAPIWrapper;
import kernel.serial_ports.comm_port_wrapper.PortIdentifierGetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inversion of Control (IOC) container for the application
 */
@Configuration
@Lazy
public class ApplicationConfiguration {
    private static final String applicationName = "BakeoutController";

    public static String getApplicationName(){
        return applicationName;
    }

    @Bean
    public static PortIdentifierGetter portWrapper(){
        return new JavaCommsAPIWrapper();
    }

    @Bean
    public static PortDriver portDriver(){
        return new RXTXPortDriver(
            getApplicationName(), portWrapper()
        );
    }

    @Bean
    public static Kernel kernel(){
        KernelFactory kernelFactory = new ApplicationKernelBootstraper();
        kernelFactory.setPortDriver(portDriver());

        assert kernelFactory.canKernelBeStarted();

        return kernelFactory.getKernelInstance();
    }
}
