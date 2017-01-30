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
 * Testing configuration for the application
 */
@Configuration
@Import(UserInterfaceConfiguration.class)
@Lazy
public class TestingConfiguration {

    private volatile Kernel mockKernel;
    private volatile Mockery mockingContext;

    @Bean
    @Scope("singleton")
    public Mockery mockingContext(){
        if(mockingContext == null) {
            mockingContext = new JUnit4Mockery() {{
                setThreadingPolicy(new Synchroniser());
            }};
        }
        return mockingContext;
    }

    @Bean
    public static List<String> testData(){
        List<String> testData = new ArrayList<>();
        testData.add("/dev/ttyUSB0");
        return testData;
    }

    @Bean
    @Scope("singleton")
    public CommPortReporter portReporter(){
        return mockingContext().mock(CommPortReporter.class);
    }

    @Bean
    @Scope("singleton")
    public Kernel kernel(){
        mockKernel = mockingContext().mock(Kernel.class);
        mockingContext().checking(
            new Expectations(){{
                allowing(mockKernel).getCommPortReporter();
                will(returnValue(portReporter()));
                allowing(portReporter()).getSerialPortNames();
                will(returnValue(testData()));
            }}
        );
        return mockKernel;
    }
}
