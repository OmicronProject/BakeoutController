package kernel.port_manager;

import exceptions.UnableToCastToIdentifierException;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import kernel.java_communications_adapter.JavaCommAdapter;
import kernel.java_communications_adapter.JavaCommunicationsAPIAdapter;
import kernel.port_manager.serial_port.SerialPort;
import kernel.port_manager.serial_port.SerialPortImpl;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Managers communication ports available on the machine
 */
public class PortManagerImpl implements PortManager {
    /**
     * The adapter to be used when working with the Java Communications API
     */
    private JavaCommunicationsAPIAdapter adapter;

    /**
     * Construct the port manager, and query for port identifiers
     */
    public PortManagerImpl(JavaCommunicationsAPIAdapter APIAdapter){
        this.adapter = APIAdapter;
    }

    /**
     * @return A list of port names accessible to the machine
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

    /**
     *
     * @param portName The name of the port that needs to be retrieved
     * @return the port Identifier
     */
    @Override public SerialPort getPortByName(String portName)
            throws NoSuchPortException {
        CommPortIdentifier portIdentifier = this.adapter
                .getCommPortIdentifier(portName);
        return new SerialPortImpl(portIdentifier);
    }

    /**
     * Iterates through a list of {@link CommPortIdentifier } and returns
     * the port names for all ports in the list
     * @param portList The list of {@link CommPortIdentifier} for which the
     *                 names are to be retrieved
     * @return A list of strings representing the port names
     */
    private static ArrayList<String> getPortNamesForPortList
            (ArrayList<CommPortIdentifier> portList){
        ArrayList<String> portNames = new ArrayList<>();

        for(CommPortIdentifier portIdentifier: portList){
            portNames.add(portIdentifier.getName());
        }

        return portNames;
    }

    /**
     * Casts an enumeration of generic objects from the Java Communications
     * API into a list of {@link CommPortIdentifier }
     * @param portIdentifiers the enumeration of port identifiers that needs
     *                        to be processed
     * @return a list of {@link CommPortIdentifier}
     */
    private static ArrayList<CommPortIdentifier> castToPortIdentifiers(
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

    /**
     * Casts the enumeration from the Java Communications API to a usable
     * {@link CommPortIdentifier}
     * @param identifier The identifier to cast
     * @return ``identifier`` cast as to the desired type
     * @throws UnableToCastToIdentifierException if the casting could not be
     *                                           done
     */
    private static CommPortIdentifier castObjectToCommPortIdentifier(
            Object identifier
    ) throws UnableToCastToIdentifierException {
        try{
            return (CommPortIdentifier)(identifier);
        } catch (ClassCastException error){
            throw new UnableToCastToIdentifierException();
        }
    }

    /**
     * Iterates through a list of {@link CommPortIdentifier} and pulls out
     * the identifiers representing all serial ports
     *
     * @param portList The list of ports to iterate
     * @return a list of serial port names
     */
    private static ArrayList<CommPortIdentifier> filterForSerialPorts
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

