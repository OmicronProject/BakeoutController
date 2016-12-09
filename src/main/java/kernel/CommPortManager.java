package kernel;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * Created by mkononen on 09/12/16.
 */
public class CommPortManager implements ICommPortManager {
    private Enumeration identifiers;

    public CommPortManager(){
        identifiers = CommPortIdentifier.getPortIdentifiers();

    }
    public Enumeration<String> getCommPortNames(){
        return new CommPortList(identifiers);
    }
}

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

