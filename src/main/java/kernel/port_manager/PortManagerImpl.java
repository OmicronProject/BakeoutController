package kernel.port_manager;

import exceptions.UnableToCastToIdentifierException;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import kernel.java_communications_adapter.JavaCommAdapter;
import kernel.java_communications_adapter.JavaCommunicationsAPIAdapter;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Managers communication ports available on the machine
 */
public class PortManagerImpl implements PortManager {
    private JavaCommunicationsAPIAdapter adapter;

    /**
     * Construct the port manager, and query for port identifiers
     */
    public PortManagerImpl(JavaCommunicationsAPIAdapter APIAdapter){
        this.adapter = APIAdapter;
    }

    /**
     * @return An enumeration of COM port names
     */
    @Override public ArrayList<String> getPortNames(){
        Enumeration portIdentifiers = this.adapter.getCommPortIdentifiers();
        ArrayList<CommPortIdentifier> portIdentifierArrayList =
                castToPortIdentifiers(portIdentifiers);
        return getPortNamesForPortList(portIdentifierArrayList);
    }

    /**
     * @return A list of serial port names
     */
    @Override public ArrayList<String> getSerialPortNames(){
        Enumeration portIdentifiers = this.adapter.getCommPortIdentifiers();

        ArrayList<CommPortIdentifier> portIdentifierList =
                castToPortIdentifiers(portIdentifiers);

        ArrayList<CommPortIdentifier> serialPortList = filterForSerialPorts
                (portIdentifierList);

        return getPortNamesForPortList(serialPortList);
    }

    private ArrayList<String> getPortNamesForPortList
            (ArrayList<CommPortIdentifier> portList){

        ArrayList<String> portNames = new ArrayList<>();

        for(CommPortIdentifier portIdentifier: portList){
            portNames.add(portIdentifier.getName());
        }

        return portNames;
    }

    private ArrayList<CommPortIdentifier> castToPortIdentifiers(
            Enumeration portIdentifiers
    ){
        ArrayList<CommPortIdentifier> identifierList = new ArrayList<>();

        while(portIdentifiers.hasMoreElements()){
            identifierList.add(
                castObjectToCommPortIdentifier(portIdentifiers.nextElement())
            );
        }
        return identifierList;
    }

    private CommPortIdentifier castObjectToCommPortIdentifier(
            Object identifier
    ){
        try{
            return (CommPortIdentifier)(identifier);
        } catch (ClassCastException error){
            throw new UnableToCastToIdentifierException();
        }
    }

    private ArrayList<CommPortIdentifier> filterForSerialPorts
            (ArrayList<CommPortIdentifier> portList){

        ArrayList<CommPortIdentifier> serialPorts = new ArrayList<>();

        for (CommPortIdentifier port: portList){
            if(port.getPortType() == CommPortIdentifier.PORT_SERIAL){
                serialPorts.add(port);
            }
        }

        return serialPorts;
    }
}

