package kernel.comm_port_manager;

import java.util.Enumeration;

/**
 * Casts each element to a string in the required enumeration
 */
class CommPortList implements Enumeration<String> {
    private Enumeration identifiers;

    /**
     * Wrap the enumeration of the COM port return
     * @param identifiers The COM port identifiers returned by the Java
     *                    Communication API
     */
    CommPortList(Enumeration identifiers){
        this.identifiers = identifiers;
    }

    /**
     * @return True if there are identifiers that have not been mentioned,
     * else False
     */
    @Override
    public boolean hasMoreElements() {
        return identifiers.hasMoreElements();
    }

    /**
     * @return The next element in the list of identifiers
     */
    @Override
    public String nextElement() {
        Object element = this.identifiers.nextElement();
        return element.toString();
    }
}

