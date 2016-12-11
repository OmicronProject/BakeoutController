package kernel.comm_port_manager;

import java.util.Enumeration;

/**
 * Casts each element to a string in the required enumeration
 */
class CommPortList implements Enumeration<String> {
    private Enumeration identifiers;

    CommPortList(Enumeration identifiers){
        this.identifiers = identifiers;
    }

    @Override
    public boolean hasMoreElements() {
        return identifiers.hasMoreElements();
    }

    @Override
    public String nextElement() {
        Object element = this.identifiers.nextElement();
        return element.toString();
    }
}

