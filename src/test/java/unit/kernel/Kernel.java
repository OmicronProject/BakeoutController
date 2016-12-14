package unit.kernel;

import kernel.comm_port_manager.ICommPortManager;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Enumeration;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the kernel is successfully able to get names of ports
 */
@RunWith(JMock.class)
public class Kernel {

    private Mockery context = new Mockery();

    @Test
    public void testGetPortNames(){
        ICommPortManager manager = context.mock(ICommPortManager.class);

        kernel.Kernel kernel = new kernel.Kernel(manager);
        MockComPortList portNames = new MockComPortList();

        context.checking(new Expectations() {{
            oneOf(manager).getCommPortNames();
            will(returnValue(portNames));
        }});

        assertEquals(portNames.getElements(), kernel.getCommPortNames());
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
