package unit.kernel.kernel_factory;

import kernel.comm_port_manager.CommPortManager;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Returns a mocked-out list of ports. Stubs out {@link CommPortManager}
 */
public class MockCommPortManager implements CommPortManager,
        Enumeration<String> {
    private final ArrayList<String> portNames;
    private int index;

    public MockCommPortManager(ArrayList<String> portNames){
        this.portNames = portNames;
        this.index = 0;
    }

    @Override public Enumeration<String> getCommPortNames(){
        return this;
    }

    @Override public boolean hasMoreElements(){
        return this.index < this.portNames.size();
    }

    @Override public String nextElement(){
        String value = this.portNames.get(this.index);
        this.index += 1;
        return value;
    }
}
