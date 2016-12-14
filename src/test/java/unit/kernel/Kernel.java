package unit.kernel;

import kernel.ApplicationKernel;
import kernel.comm_port_manager.CommPortManager;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Enumeration;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the kernel is successfully able to get names of ports
 */
public class Kernel {
    private static final String appName = "app";

    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testGetPortNames(){
        CommPortManager manager = context.mock(CommPortManager.class);

        ApplicationKernel applicationKernel = new ApplicationKernel(appName, manager);
        MockComPortList portNames = new MockComPortList();

        class ExpectedResponse extends Expectations {
            ExpectedResponse(){
                oneOf(manager).getCommPortNames();
                will(returnValue(portNames));
            }
        }

        context.checking(new ExpectedResponse());

        assertEquals(portNames.getElements(), applicationKernel.getCommPortNames());
        context.assertIsSatisfied();
    }
}

class MockComPortList implements Enumeration {
    private int index;
    private ArrayList<String> data;
    private int size;

    MockComPortList(){
        index = 0;
        data = new ArrayList<>();
        data.add("COM1");
        data.add("COM2");

        size = data.size();
    }

    @Override public String nextElement() {
        String value_to_return = data.get(index);
        this.index += 1;
        return value_to_return;
    }

    @Override public boolean hasMoreElements(){
        return index < size;
    }

    public ArrayList<String> getElements(){
        return data;
    }
}
