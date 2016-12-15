package unit.kernel;

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

    /**
     * If a no-argument constructor is used, add some test data to the mock
     * array to return.
     */
    public MockCommPortManager(){
        ArrayList<String> portNames = new ArrayList<>();
        portNames.add("COM1");
        portNames.add("COM2");

        this.portNames = portNames;
        this.index = 0;
    }

    /**
     * Initialize using a pre-determined port list
     * @param portNames The array of strings representing port names
     */
    public MockCommPortManager(ArrayList<String> portNames){
        this.portNames = portNames;
        this.index = 0;
    }

    /**
     * @return An enumeration of the port names as returned by the Java Comm
     * API
     */
    @Override public Enumeration<String> getCommPortNames(){
        return this;
    }

    /**
     * @return True if there are elements left in the list, else false. This
     * class is its own enumeration as well, in order to save code.
     */
    @Override public boolean hasMoreElements(){
        return this.index < this.portNames.size();
    }

    /**
     * @return The next element in the list of COM Port names
     */
    @Override public String nextElement(){
        String value = this.portNames.get(this.index);
        this.index += 1;
        return value;
    }

    /**
     * @return The array of port names
     */
    public ArrayList<String> getPortNames(){ return this.portNames; }
}
