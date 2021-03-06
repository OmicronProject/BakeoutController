package unit.ui;

import kernel.Kernel;
import kernel.views.CommPortReporter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.springframework.context.annotation.*;
import ui.UserInterfaceConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for producing mock beans for the dependencies for this
 * application
 */
@Configuration
@Import(UserInterfaceConfiguration.class)
@Lazy
public class TestingConfiguration {

    /**
     * A stub representing {@link kernel.Kernel}
     */
    private volatile Kernel mockKernel;

    /**
     * The context in which mock beans are to be created
     */
    private volatile Mockery mockingContext;

    /**
     * @return The context in which mockery is to take place
     */
    @Bean
    @Scope("singleton")
    public Mockery mockingContext(){
        if(mockingContext == null) {
            mockingContext = new SynchronizedJUnit4Mockery();
        }
        return mockingContext;
    }

    /**
     * @return A list containing data of serial ports
     */
    @Bean
    @Scope("prototype")
    public static List<String> testData(){
        List<String> testData = new ArrayList<>();
        testData.add("/dev/ttyUSB0");
        return testData;
    }

    /**
     * @return A mock reporter for returning serial port names
     */
    @Bean
    @Scope("singleton")
    public CommPortReporter portReporter(){
        return mockingContext().mock(CommPortReporter.class);
    }

    /**
     * @return A mock kernel
     */
    @Bean
    @Scope("singleton")
    public Kernel kernel(){
        mockKernel = mockingContext().mock(Kernel.class);
        mockingContext().checking(new ExpectationsForKernel());
        return mockKernel;
    }

    /**
     * The mockery that is to be used. This is an extension of the
     * traditional {@link JUnit4Mockery}, but with a {@link Synchroniser} to
     * manage access to mock objects across threads
     */
    private class SynchronizedJUnit4Mockery extends JUnit4Mockery {
        /**
         * Creates the mockery
         */
        public SynchronizedJUnit4Mockery(){
            setThreadingPolicy(new Synchroniser());
        }
    }

    /**
     * Defines the default allowed behaviour out of the stubbed-out
     * {@link kernel.Kernel}.
     */
    private class ExpectationsForKernel extends Expectations {
        /**
         * Set up the required behaviours
         */
        public ExpectationsForKernel(){
            expectationsForPortReporter();
            expectationsForSerialPortNames();
        }

        /**
         * Defines allowed behaviour for {@link Kernel#getCommPortReporter()}
         */
        private void expectationsForPortReporter(){
            allowing(mockKernel).getCommPortReporter();
            will(returnValue(portReporter()));
        }

        /**
         * Defines allowed behaviour for
         * {@link CommPortReporter#getSerialPortNames()}
         */
        private void expectationsForSerialPortNames(){
            allowing(portReporter()).getSerialPortNames();
            will(returnValue(testData()));
        }
    }
}
