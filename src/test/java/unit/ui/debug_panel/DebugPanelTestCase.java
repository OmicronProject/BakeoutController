package unit.ui.debug_panel;

import kernel.Kernel;
import kernel.views.CommPortReporter;
import org.jmock.Expectations;
import org.junit.Before;
import unit.ui.UserInterfaceTestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkononen on 30/01/17.
 */
public abstract class DebugPanelTestCase extends UserInterfaceTestCase {
    protected Kernel mockKernel;
    protected CommPortReporter mockCommPortReporter;
    protected List<String> testData;
    protected String portName = "/dev/ttyUSB0";

    @Before
    public void setMockKernel(){
        mockKernel = context.mock(Kernel.class);
    }

    @Before
    public void setMockCommPortReporter(){
        mockCommPortReporter = context.mock(CommPortReporter.class);
    }

    @Before
    public void contextExpectations(){
        context.checking(new KernelExpectations(testData));
    }

    @Before
    public void setTestData(){
        testData = new ArrayList<>();
        testData.add(portName);
    }

    public class KernelExpectations extends org.jmock.Expectations {
        private List<String> testData;

        public KernelExpectations(List<String> testData){
            this.testData = testData;
            checkKernel();
            prepareCommPortReport();
        }

        private void checkKernel(){
            oneOf(mockKernel).getCommPortReporter();
            will(returnValue(mockCommPortReporter));
        }

        private void prepareCommPortReport(){
            oneOf(mockCommPortReporter).getSerialPortNames();
            will(returnValue(this.testData));
        }
    }
}
